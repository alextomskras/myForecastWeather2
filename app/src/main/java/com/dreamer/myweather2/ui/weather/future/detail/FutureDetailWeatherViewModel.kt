package com.dreamer.myweather2.ui.weather.future.detail


import com.dreamer.myweather2.data.provider.UnitProvider
import com.dreamer.myweather2.data.repository.ForecastRepository
import com.dreamer.myweather2.internal.lazyDeferred
import com.dreamer.myweather2.ui.base.WeatherViewModel
import org.threeten.bp.LocalDateTime

class FutureDetailWeatherViewModel(
        private val detailDate: LocalDateTime,
        private val forecastRepository: ForecastRepository,
        unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {

    val weather by lazyDeferred {
        forecastRepository.getFutureWeatherByDate(detailDate, super.isMetricUnit)
    }
}
