package com.resocoder.myweather2.ui.weather.current

import com.resocoder.myweather2.data.provider.UnitProvider
import com.resocoder.myweather2.data.repository.ForecastRepository
import com.resocoder.myweather2.internal.lazyDeferred
import com.resocoder.myweather2.ui.base.WeatherViewModel

class CurrentWeatherViewModel(
        private val forecastRepository: ForecastRepository,
        unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {

    val weather by lazyDeferred {
        forecastRepository.getCurrentWeather(super.isMetricUnit)
    }
}
