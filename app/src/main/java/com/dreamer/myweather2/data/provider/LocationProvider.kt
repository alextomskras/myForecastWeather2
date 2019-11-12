package com.dreamer.myweather2.data.provider

import com.dreamer.myweather2.data.db.entity.openweatherapi.Coord


interface LocationProvider {
    suspend fun hasLocationChanged(lastWeatherLocation: Coord?): Boolean
    suspend fun getPreferredLocationString(): String
}