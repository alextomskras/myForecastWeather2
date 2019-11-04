package com.resocoder.myweather2.ui.weather.future.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.resocoder.myweather2.data.provider.UnitProvider
import com.resocoder.myweather2.data.repository.ForecastRepository
import org.threeten.bp.LocalDate


class FutureDetailWeatherViewModelFactory(
        private val detailDate: LocalDate,
        private val forecastRepository: ForecastRepository,
        private val unitProvider: UnitProvider
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FutureDetailWeatherViewModel(detailDate, forecastRepository, unitProvider) as T
    }
}