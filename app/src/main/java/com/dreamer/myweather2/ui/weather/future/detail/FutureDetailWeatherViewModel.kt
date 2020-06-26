package com.dreamer.myweather2.ui.weather.future.detail


import com.dreamer.myweather2.data.provider.UnitProvider
import com.dreamer.myweather2.data.repository.ForecastRepository
import com.dreamer.myweather2.internal.lazyDeferred
import com.dreamer.myweather2.ui.base.WeatherViewModel
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter

class FutureDetailWeatherViewModel(
        private val detailDate: LocalDateTime,
        private val forecastRepository: ForecastRepository,
        unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {

    val weather by lazyDeferred {
        val dtFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
//        val detailDate = detailDate.toEpochSecond(ZoneOffset.ofHours(4))
        val detailDate = detailDate

//                .let { it ->
//            Log.e("WeatherViewModel", "date1String:: $detailDate")
//            LocalDateTime.parse(it,dtFormatter)
//        }
        forecastRepository.getFutureWeatherByDate(detailDate, super.isMetricUnit)
    }
}
