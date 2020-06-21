package com.dreamer.myweather2.data.db.unitlocalized.future.list

import org.threeten.bp.LocalDateTime


interface UnitSpecificSimpleFutureWeatherEntry {
    val date: LocalDateTime
    val avgTemperature: Double
    val conditionText: Double
    val conditionIconUrl: Double
}