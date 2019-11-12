package com.dreamer.myweather2.data.repository

import androidx.lifecycle.LiveData
import com.dreamer.myweather2.data.db.entity.openweatherapi.Coord
import com.dreamer.myweather2.data.db.unitlocalized.current.UnitSpecificCurrentWeatherEntry


interface ForecastRepository {
    suspend fun getCurrentWeather(metric: Boolean): LiveData<out UnitSpecificCurrentWeatherEntry>

//    suspend fun getFutureWeatherList(startDate: LocalDate, metric: Boolean): LiveData<out List<UnitSpecificSimpleFutureWeatherEntry>>
//
//    suspend fun getFutureWeatherByDate(date: LocalDate, metric: Boolean): LiveData<out UnitSpecificDetailFutureWeatherEntry>

    suspend fun getWeatherLocation(): LiveData<Coord>
}