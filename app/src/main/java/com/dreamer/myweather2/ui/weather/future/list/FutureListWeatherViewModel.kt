package com.dreamer.myweather2.ui.weather.future.list

import com.dreamer.myweather2.data.provider.UnitProvider
import com.dreamer.myweather2.data.repository.ForecastRepository
import com.dreamer.myweather2.internal.lazyDeferred
import com.dreamer.myweather2.ui.base.WeatherViewModel
import org.threeten.bp.LocalDate

class FutureListWeatherViewModel(
        private val forecastRepository: ForecastRepository,
        unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {

    val weatherEntries by lazyDeferred {
        forecastRepository.getFutureWeatherList(LocalDate.now(), super.isMetricUnit)
    }
}
