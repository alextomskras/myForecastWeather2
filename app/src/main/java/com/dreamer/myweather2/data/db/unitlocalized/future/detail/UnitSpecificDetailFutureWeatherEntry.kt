package com.dreamer.myweather2.data.db.unitlocalized.future.detail

import com.dreamer.myweather2.data.db.entity.furute.Weather
import org.threeten.bp.LocalDateTime


interface UnitSpecificDetailFutureWeatherEntry {
    val date: LocalDateTime

    val dt: Int
    val maxTemperature: Double
    val minTemperature: Double
    val avgTemperature: Double
    val conditionText: List<out (Weather)>

    //    val conditionIconUrl: String
    val maxWindSpeed: Double
    val totalPressure: Double
    val avgVisibilityDistance: Double
//    val uv: Double
}