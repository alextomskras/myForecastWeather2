package com.dreamer.myweather2.data.network.response

import com.dreamer.myweather2.data.db.entity.CurrentWeatherEntry
import com.dreamer.myweather2.data.db.entity.Request
import com.dreamer.myweather2.data.db.entity.WeatherLocation
import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
        @SerializedName("request")
//        @Embedded(prefix = "request_")
        val request: Request,
        @SerializedName("location")
        val location: WeatherLocation,
        @SerializedName("current")
        val currentWeatherEntry: CurrentWeatherEntry
)