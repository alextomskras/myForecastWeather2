package com.dreamer.myweather2.data.db.unitlocalized.future.list

import com.dreamer.myweather2.data.db.entity.furute.Weather
import org.threeten.bp.LocalDateTime


interface UnitSpecificSimpleFutureWeatherEntry {
    val date: LocalDateTime
    val avgTemperature: Double
    val conditionText: List<out (Weather)>
    val conditionIconUrl: Double
}