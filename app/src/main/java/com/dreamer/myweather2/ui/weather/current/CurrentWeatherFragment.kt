package com.dreamer.myweather2.ui.weather.current

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.dreamer.myweather2.R
import com.dreamer.myweather2.ui.base.ScopedFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.current_weather_fragment.*
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance
import org.threeten.bp.Instant
import org.threeten.bp.ZoneId
import org.threeten.bp.format.DateTimeFormatter


class CurrentWeatherFragment : ScopedFragment(), KodeinAware {

    override val kodein by closestKodein()
    private val viewModelFactory: CurrentWeatherViewModelFactory by instance()

    private lateinit var viewModel: CurrentWeatherViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.current_weather_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(CurrentWeatherViewModel::class.java)

        bindUI()
    }

    private fun bindUI() = launch {
        val currentWeather = viewModel.weather.await()

        val weatherLocation = viewModel.weatherLocation.await()

        weatherLocation.observe(viewLifecycleOwner, Observer { location ->
            if (location == null) return@Observer
//            updateLocation(location.lat.toInt())
            updateLocation(location.lat.toString())
        })

        currentWeather.observe(viewLifecycleOwner, Observer {
            //            if (it == null) return@Observer

            group_loading.visibility = View.GONE
            //правим заголовок окна - выставляем "Today"
            updateDateToToday()
            //Передаем значения температуры полученные из запроса
            it?.main?.tempMin?.let { it1 -> updateTemperatures(it.main.temp.toString(), it.main.feelsLike, it.main.tempMin, it.main.tempMax) }
            //Выводим в error-логи содержимое запроса
            Log.e(this.toString(), "from updateTemperatures: ${it?.main?.temp.toString()}")
//            updateTemperatures(22.1, 33.4)
            //Передаем описание погоды "например - мелкий дождь"
            updateCondition(it.weather[0].description)
            //Выводим в error-логи содержимое запроса "it.futureWeather[0].description"
            Log.e(this.toString(), "from updateCondition: ${it.weather[0].description}")

////            System.out.println(it.conditionText.substring(1, it.conditionText.length()-1))
//            val sb = StringBuilder()
//            sb.append("${it.conditionText}").substring(1, it.conditionText.length - 1)
////                    .lastIndexOf(sb.toString(),0)
//            val c = it.conditionText.substring(1, it.conditionText.length - 1)
////            sb.deleteCharAt(c-1)
////            val d = sb.toString()
//            Log.d(this.toString(), "from conditionText2 error code: $c")
//            updateCondition(c)
//            updateLocation(it.location.lat)
            updateLocation(it.name)

            updatePrecipitation(it.main.pressure)
//            updatePrecipitation(it.precipitationVolume)
            updateWind(it.wind.deg.toString(), it.wind.speed)
            updateVisibility(it.visibility.toDouble())
            updateSunrise(it.sys.sunrise)
            updateSunset(it.sys.sunset)
//            updateVisibility(it.visibilityDistance)
            val picturesUrl = it.weather[0].icon
//            var picturesUrl = it.conditionIconUrl
//            if (picturesUrl.startsWith("\""))
//                picturesUrl = picturesUrl.replace("\"", "")
            Log.e(this.toString(), "from with2 error code: $picturesUrl")
            try {
                Picasso.get()
//                        .load("${picturesUrl}")
                        .load("http://openweathermap.org/img/wn/" + "$picturesUrl" + "@2x" + ".png")
//                        .load("https://assets.weatherstack.com/images/wsymbols01_png_64/wsymbol_0008_clear_sky_night.png")
                        .fit()
                        .into(imageView_condition_icon_future)
            } catch (e: Exception) {
                e.printStackTrace()
            }
//            try {
//                var url = pictures /* URL of Image */
//
//                if (url.startsWith("http://"))
//                    url = url.replace("http://", "https://")
//
//                val requestOptions = RequestOptions()
////                requestOptions.placeholder(ic_launcher)
////                requestOptions.error(ic_launcher_round)
//                Glide
//                        .with(this@CurrentWeatherFragment)
////                        .setDefaultRequestOptions(requestOptions)
//                        .load(url)
//                        .into(imageView_condition_icon)
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }

//            GlideApp.with(this@CurrentWeatherFragment)
//
//                    .load(picTures)
//
////                    .load("https://assets.weatherstack.com/images/wsymbols01_png_64/wsymbol_0008_clear_sky_night.png")
//                    .into(imageView_condition_icon)
////            Log.d(this.toString(), "fromListLisr with2 error code: ${it.conditionIconUrl}")
        }
        )
    }

    private fun chooseLocalizedUnitAbbreviation(metric: String, imperial: String): String {
        return if (viewModel.isMetricUnit) metric else imperial
    }

    private fun updateLocation(location: String) {
//        MainActivity().nameCity = location
        (activity as? AppCompatActivity)?.supportActionBar?.title = location.toString()
//        (activity as? AppCompatActivity)?.supportActionBar?.title = location.toString()
    }

    private fun updateDateToToday() {
        (activity as? AppCompatActivity)?.supportActionBar?.subtitle = getString(R.string.Curtoday)
    }

    private fun updateTemperatures(temperature: String, feelsLike: Double, tempMin: Double, tempMax: Double) {
        val unitAbbreviation = chooseLocalizedUnitAbbreviation("°C", "°F")
        textView_temperature.text = "$temperature$unitAbbreviation"
        textView_min_max_temperature_current.text = "Min:" + "$tempMin$unitAbbreviation" + "," + "Max:" + "$tempMax$unitAbbreviation"
        textView_feels_like_temperature.text = "Feels like" + " $feelsLike$unitAbbreviation"
    }

    private fun updateCondition(condition: String) {
        textView_condition.text = condition
    }

    private fun updatePrecipitation(precipitationVolume: Int) {
        val unitAbbreviation = chooseLocalizedUnitAbbreviation("mm", "in")
        textView_precipitation.text = getString(R.string.CurPreciptiation) + ": $precipitationVolume $unitAbbreviation"
    }

    private fun updateWind(windDirection: String, windSpeed: Double) {
        val unitAbbreviation = chooseLocalizedUnitAbbreviation("ms", "mph")
        val WindDirectionstoWords = transformWindDirectionstoWords(windDirection)

//        textView_wind.text = "Wind: $windDirection, $windSpeed $unitAbbreviation"
        textView_wind.text = getString(R.string.CurWind) + ": $WindDirectionstoWords, $windSpeed $unitAbbreviation"
    }

    private fun transformWindDirectionstoWords(windDirection: String): String {
//        val zarplata = 1000
//        val cost = when (zarplata) {
//            in 1..10 -> "издеваетесь?"
//            in 10..100 -> "маловато будет"
//            in 100..1000 -> "кота прокормлю"
//            in 1000..1000000 -> "на хлеб с икрой!"
//            else -> "not rated"
//        }
//        println(cost)
//
//        N
//
//
//        348.75 - 11.25
//
//        NNE
//
//
//        11.25 - 33.75
//
//        NE
//
//
//        33.75 - 56.25
//
//        ENE
//
//
//        56.25 - 78.75
//
//        E
//
//
//        78.75 - 101.25
//
//        ESE
//
//
//        101.25 - 123.75
//
//        SE
//
//
//        123.75 - 146.25
//
//        SSE
//
//
//        146.25 - 168.75
//
//        S
//
//
//        168.75 - 191.25
//
//        SSW
//
//
//        191.25 - 213.75
//
//        SW
//
//
//        213.75 - 236.25
//
//        WSW
//
//
//        236.25 - 258.75
//
//        W
//
//
//        258.75 - 281.25
//
//        WNW
//
//
//        281.25 - 303.75
//
//        NW
//
//
//        303.75 - 326.25
//
//        NNW
//
//
//        326.25 - 348.75

        return when (windDirection.toDouble()) {
            in 348.75..11.25 -> "N"
            in 11.25..33.75 -> "NNE"
            in 33.75..56.25 -> "NE"
            in 56.25..78.75 -> "ENE"
            in 78.75..101.25 -> "E"
            in 101.25..123.75 -> "ESE"
            in 123.75..146.25 -> "SE"
            in 146.25..168.75 -> "SSE"
            in 168.75..191.25 -> "S"
            in 191.25..213.75 -> "SSW"
            in 213.75..236.25 -> "SW"
            in 236.25..258.75 -> "WSW"
            in 258.75..281.25 -> "W"
            in 281.25..303.75 -> "WNW"
            in 303.75..326.25 -> "NW"
            in 326.25..348.75 -> "NNW"
            else -> "not rated"

        }
    }

    private fun updateVisibility(visibilityDistance: Double) {
        val unitAbbreviation = chooseLocalizedUnitAbbreviation("m", "mi.")
        textView_visibility.text = getString(R.string.CurVisibility) + ": $visibilityDistance $unitAbbreviation"
    }

    private fun updateSunrise(sunriseTime: Int) {
        val dt = Instant.ofEpochSecond(sunriseTime.toLong())
                .atZone(ZoneId.systemDefault())
//                .toLocalTime()
                .toLocalDateTime()
                .format(DateTimeFormatter.ISO_LOCAL_TIME)

        val unitAbbreviation = chooseLocalizedUnitAbbreviation("h", "mi.")
        val testTime1 = sunriseTime
        textView_sunrise.text = getString(R.string.CurSunrise) + ": $dt"
    }

    private fun updateSunset(sunsetTime: Int) {
        //превращаем секунды в нормальный формат даты
        val dt = Instant.ofEpochSecond(sunsetTime.toLong())
                .atZone(ZoneId.systemDefault())
                .toLocalTime()
                //                .toLocalDateTime()
                .format(DateTimeFormatter.ISO_LOCAL_TIME)

        val unitAbbreviation = chooseLocalizedUnitAbbreviation("h", "mi.")
        val testTime2 = sunsetTime
        textView_sunset.text = getString(R.string.CurSunset) + ": $dt "
    }

}
