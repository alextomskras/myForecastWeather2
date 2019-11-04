package com.resocoder.myweather2.ui.base

import androidx.lifecycle.ViewModel
import com.resocoder.myweather2.data.provider.UnitProvider
import com.resocoder.myweather2.data.repository.ForecastRepository
import com.resocoder.myweather2.internal.UnitSystem
import com.resocoder.myweather2.internal.lazyDeferred


abstract class WeatherViewModel(
        private val forecastRepository: ForecastRepository,
        unitProvider: UnitProvider
) : ViewModel() {

    private val unitSystem = unitProvider.getUnitSystem()

    val isMetricUnit: Boolean
        get() = unitSystem == UnitSystem.METRIC

    val weatherLocation by lazyDeferred {
        forecastRepository.getWeatherLocation()
    }
}