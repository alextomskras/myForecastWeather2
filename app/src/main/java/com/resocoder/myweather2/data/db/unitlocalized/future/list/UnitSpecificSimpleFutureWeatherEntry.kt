package com.resocoder.myweather2.data.db.unitlocalized.future.list

import org.threeten.bp.LocalDate


interface UnitSpecificSimpleFutureWeatherEntry {
    val date: LocalDate
    val avgTemperature: Double
    val conditionText: String
    val conditionIconUrl: String
}