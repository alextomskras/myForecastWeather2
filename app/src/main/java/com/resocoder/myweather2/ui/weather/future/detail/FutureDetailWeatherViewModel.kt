package com.resocoder.myweather2.ui.weather.future.detail

import com.resocoder.myweather2.data.provider.UnitProvider
import com.resocoder.myweather2.data.repository.ForecastRepository
import com.resocoder.myweather2.internal.lazyDeferred
import com.resocoder.myweather2.ui.base.WeatherViewModel
import org.threeten.bp.LocalDate

class FutureDetailWeatherViewModel(
        private val detailDate: LocalDate,
        private val forecastRepository: ForecastRepository,
        unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {

    val weather by lazyDeferred {
        forecastRepository.getFutureWeatherByDate(detailDate, super.isMetricUnit)
    }
}
