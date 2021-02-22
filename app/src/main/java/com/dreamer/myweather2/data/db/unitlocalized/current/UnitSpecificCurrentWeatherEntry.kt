package com.dreamer.myweather2.data.db.unitlocalized.current

import com.dreamer.myweather2.data.db.entity.openweatherapi.WeatherEntry


interface UnitSpecificCurrentWeatherEntry {
    val temperature: Double
    val temperatureMax: Double
    val temperatureMin: Double

    //    val conditionText: String
    val conditionText: List<out (WeatherEntry)>

    //    val conditionIconUrl: String
    val windSpeed: Double
    val windDirection: String
    val precipitationVolume: Int
    val feelsLikeTemperature: Double
    val sysSunrise: Double
    val sysSunset: Double
    val visibilityDistance: Double
}