package com.resocoder.myweather2.data.network.response

import com.google.gson.annotations.SerializedName
import com.resocoder.myweather2.data.db.entity.CurrentWeatherEntry
import com.resocoder.myweather2.data.db.entity.Request
import com.resocoder.myweather2.data.db.entity.WeatherLocation

data class CurrentWeatherResponse(
        @SerializedName("request")
//        @Embedded(prefix = "request_")
        val request: Request,
        val location: WeatherLocation,
        @SerializedName("current")
        val currentWeatherEntry: CurrentWeatherEntry
)