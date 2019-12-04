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

        weatherLocation.observe(this@CurrentWeatherFragment, Observer { location ->
            if (location == null) return@Observer
            updateLocation(location.lat.toInt())
        })

        currentWeather.observe(this@CurrentWeatherFragment, Observer {
            //            if (it == null) return@Observer

            group_loading.visibility = View.GONE
            updateDateToToday()
            it?.main?.tempMin?.let { it1 -> updateTemperatures(it.main.temp.toString(), it1) }
//            updateTemperatures(22.1, 33.4)
            updateCondition(it.weather[0].description)
            Log.e(this.toString(), "from conditionText2: ${it?.main?.temp.toString()}")
////            System.out.println(it.conditionText.substring(1, it.conditionText.length()-1))
//            val sb = StringBuilder()
//            sb.append("${it.conditionText}").substring(1, it.conditionText.length - 1)
////                    .lastIndexOf(sb.toString(),0)
//            val c = it.conditionText.substring(1, it.conditionText.length - 1)
////            sb.deleteCharAt(c-1)
////            val d = sb.toString()
//            Log.d(this.toString(), "from conditionText2 error code: $c")
//            updateCondition(c)
            updatePrecipitation(it.main.pressure)
//            updatePrecipitation(it.precipitationVolume)
            updateWind(it.wind.deg.toString(), it.wind.speed)
            updateVisibility(it.visibility.toDouble())
//            updateVisibility(it.visibilityDistance)
            val picturesUrl = it.weather[0].icon
//            var picturesUrl = it.conditionIconUrl
//            if (picturesUrl.startsWith("\""))
//                picturesUrl = picturesUrl.replace("\"", "")
            Log.e(this.toString(), "from with2 error code: $picturesUrl")
            try {
                Picasso.get()
//                        .load("${picturesUrl}")
                        .load("http://openweathermap.org/img/wn/" + "$picturesUrl" + ".png")
//                        .load("https://assets.weatherstack.com/images/wsymbols01_png_64/wsymbol_0008_clear_sky_night.png")
                        .fit()
                        .into(imageView_condition_icon)
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

    private fun updateLocation(location: Int) {
        (activity as? AppCompatActivity)?.supportActionBar?.title = location.toString()
//        (activity as? AppCompatActivity)?.supportActionBar?.title = location.toString()
    }

    private fun updateDateToToday() {
        (activity as? AppCompatActivity)?.supportActionBar?.subtitle = "Today"
    }

    private fun updateTemperatures(temperature: String, feelsLike: Double) {
        val unitAbbreviation = chooseLocalizedUnitAbbreviation("°C", "°F")
        textView_temperature.text = "$temperature$unitAbbreviation"
        textView_feels_like_temperature.text = "Feels like $feelsLike$unitAbbreviation"
    }

    private fun updateCondition(condition: String) {
        textView_condition.text = condition
    }

    private fun updatePrecipitation(precipitationVolume: Int) {
        val unitAbbreviation = chooseLocalizedUnitAbbreviation("mm", "in")
        textView_precipitation.text = "Preciptiation: $precipitationVolume $unitAbbreviation"
    }

    private fun updateWind(windDirection: String, windSpeed: Double) {
        val unitAbbreviation = chooseLocalizedUnitAbbreviation("kph", "mph")
        textView_wind.text = "Wind: $windDirection, $windSpeed $unitAbbreviation"
    }

    private fun updateVisibility(visibilityDistance: Double) {
        val unitAbbreviation = chooseLocalizedUnitAbbreviation("m", "mi.")
        textView_visibility.text = "Visibility: $visibilityDistance $unitAbbreviation"
    }

}
