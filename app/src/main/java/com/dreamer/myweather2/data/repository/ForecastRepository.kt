package com.dreamer.myweather2.data.repository

import androidx.lifecycle.LiveData
import com.dreamer.myweather2.data.db.entity.WeatherLocation
import com.dreamer.myweather2.data.db.unitlocalized.current.UnitSpecificCurrentWeatherEntry
import com.dreamer.myweather2.data.db.unitlocalized.future.detail.UnitSpecificDetailFutureWeatherEntry
import com.dreamer.myweather2.data.db.unitlocalized.future.list.UnitSpecificSimpleFutureWeatherEntry
import org.threeten.bp.LocalDate


interface ForecastRepository {
    suspend fun getCurrentWeather(metric: Boolean): LiveData<out UnitSpecificCurrentWeatherEntry>

    suspend fun getFutureWeatherList(startDate: LocalDate, metric: Boolean): LiveData<out List<UnitSpecificSimpleFutureWeatherEntry>>

    suspend fun getFutureWeatherByDate(date: LocalDate, metric: Boolean): LiveData<out UnitSpecificDetailFutureWeatherEntry>

    suspend fun getWeatherLocation(): LiveData<WeatherLocation>
}