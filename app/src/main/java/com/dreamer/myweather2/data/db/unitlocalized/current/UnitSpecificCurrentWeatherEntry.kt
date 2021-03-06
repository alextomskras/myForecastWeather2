package com.dreamer.myweather2.data.db.unitlocalized.current


interface UnitSpecificCurrentWeatherEntry {
    val temperature: Double
    val conditionText: String
    //    val conditionIconUrl: String
//    val windSpeed: Double
//    val windDirection: String
    val precipitationVolume: Int
    //    val feelsLikeTemperature: Double
    val visibilityDistance: Double
}