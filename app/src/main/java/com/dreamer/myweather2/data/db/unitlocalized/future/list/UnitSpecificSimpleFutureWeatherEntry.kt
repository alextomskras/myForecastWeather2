package com.dreamer.myweather2.data.db.unitlocalized.future.list

import org.threeten.bp.LocalDate


interface UnitSpecificSimpleFutureWeatherEntry {
    val date: LocalDate
    val avgTemperature: Double
    val conditionText: Double
    val conditionIconUrl: Double
}