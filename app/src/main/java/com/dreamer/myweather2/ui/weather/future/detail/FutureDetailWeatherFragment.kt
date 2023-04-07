package com.dreamer.myweather2.ui.weather.future.detail


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.dreamer.myweather2.R
import com.dreamer.myweather2.internal.DateNotFoundException
import com.dreamer.myweather2.internal.glide.GlideApp
import com.dreamer.myweather2.ui.base.ScopedFragment
import kotlinx.android.synthetic.main.future_detail_weather_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.factory
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.FormatStyle


class FutureDetailWeatherFragment : ScopedFragment(), KodeinAware {

    override val kodein by closestKodein()

    private val viewModelFactoryInstanceFactory
            : ((LocalDateTime) -> FutureDetailWeatherViewModelFactory) by factory()

    private lateinit var viewModel: FutureDetailWeatherViewModel
//    private val cityName : String   = MainActivity().nameCity

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.future_detail_weather_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val safeArgs = arguments?.let {
            FutureDetailWeatherFragmentArgs.fromBundle(it)
        }
        val dtFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
//        val date = LocalDateConverter.stringToDate(str = safeArgs?.dateString)
        val date = safeArgs?.dateString

            ?: throw DateNotFoundException()

//        weatherEntry.date.format(dtFormatter)
//        val date1 = LocalDateTime(date.toLocalDate())
        val date1 = LocalDateTime.parse(date, dtFormatter)
        Log.e("onActivityCreated", "dateString:: $date")
        Log.e("onActivityCreated", "date1String:: $date1")

        viewModel = ViewModelProviders.of(this, viewModelFactoryInstanceFactory(date1))
                .get(FutureDetailWeatherViewModel::class.java)

        bindUI()
    }

    private fun bindUI() = launch(Dispatchers.Main) {
        val futureWeather = viewModel.weather.await()
        val weatherLocation = viewModel.weatherLocation.await()

        weatherLocation.observe(viewLifecycleOwner, Observer { location ->
            if (location == null) return@Observer
//            updateLocation(location.lat.toString())
            updateLocation(getString(R.string.Weather_details))
        })

        futureWeather.observe(viewLifecycleOwner, Observer { weatherEntry ->
//            if (weatherEntry == null) return@Observer

//            updateDate(1111)
            updateDate(weatherEntry.date)
//            updateDate(weatherEntry.dt)
//            updateTemperatures(weatherEntry.avgTemperature,
//                    11.1, 15.3)
//            updateCondition("sneg")
//            updatePrecipitation(211.2)
//            updateWindSpeed(12.1)
            updateVisibility(333.1)
//            updateUv(12.1)
            updateTemperatures(weatherEntry.avgTemperature,
                    weatherEntry.minTemperature, weatherEntry.maxTemperature)
            updateCondition(weatherEntry.conditionText.last().description)
            updatePrecipitation(weatherEntry.totalPressure)
            updateWindSpeed(weatherEntry.maxWindSpeed)
            updateVisibility(weatherEntry.avgVisibilityDistance / 1000)
//            updateUv(weatherEntry.uv)
            val iconUrl = weatherEntry.conditionText.last().icon
            Log.e(this.toString(), "from iconUrl error code: $iconUrl")



            GlideApp.with(this@FutureDetailWeatherFragment)
//                .load("http:" + weatherEntry.conditionIconUrl)
                    .load("http://openweathermap.org/img/wn/" + "$iconUrl" + "@2x" + ".png")
                    .into(imageView_condition_icon_future_detail)
        })
    }

    private fun chooseLocalizedUnitAbbreviation(metric: String, imperial: String): String {
        return if (viewModel.isMetricUnit) metric else imperial
    }

    private fun updateLocation(location: String) {
//        MainActivity().nameCity
//        (activity as? AppCompatActivity)?.supportActionBar?.title = location
        (activity as? AppCompatActivity)?.supportActionBar?.title = location
    }

    private fun updateDate(date: LocalDateTime) {
        val dtFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        (activity as? AppCompatActivity)?.supportActionBar?.subtitle =

            date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))
//                date.format(dtFormatter)
    }

    private fun updateTemperatures(temperature: Double, min: Double, max: Double) {
        val unitAbbreviation = chooseLocalizedUnitAbbreviation("°C", "°F")
        textView_temperature_detail.text = "${temperature.toInt()}$unitAbbreviation"
        textView_min_max_temperature.text = getString(R.string.futMin) + ": ${min.toInt()}$unitAbbreviation, " + getString(R.string.futMax) + ": ${max.toInt()}$unitAbbreviation"
    }

    private fun updateCondition(condition: String) {
        textView_condition.text = condition
    }

    private fun updatePrecipitation(precipitationVolume: Double) {
        val unitAbbreviation = chooseLocalizedUnitAbbreviation("mm", "in")
        textView_precipitation.text = getString(R.string.futPressure) + ": ${precipitationVolume.toInt()} $unitAbbreviation"
    }

    private fun updateWindSpeed(windSpeed: Double) {
        val unitAbbreviation = chooseLocalizedUnitAbbreviation("ms", "mph")
        textView_wind.text = getString(R.string.futWindSpeed) + ": ${windSpeed.toInt()} $unitAbbreviation"
    }

    private fun updateVisibility(visibilityDistance: Double) {
        val unitAbbreviation = chooseLocalizedUnitAbbreviation("km", "mi.")
        textView_visibility.text = getString(R.string.futVisibility) + ": ${visibilityDistance.toInt()} $unitAbbreviation"
    }

    private fun updateUv(uv: Double) {
        textView_uv.text = getString(R.string.futUV) + ": $uv"
    }
}


