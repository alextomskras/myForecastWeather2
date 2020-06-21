package com.dreamer.myweather2.data.db.unitlocalized.future.detail

import org.threeten.bp.LocalDateTime


interface UnitSpecificDetailFutureWeatherEntry {
    val date: LocalDateTime
    val maxTemperature: Double
//    val minTemperature: Double
//    val avgTemperature: Double
//    val conditionText: String
//    val conditionIconUrl: String
//    val maxWindSpeed: Double
//    val totalPrecipitation: Double
//    val avgVisibilityDistance: Double
//    val uv: Double
}