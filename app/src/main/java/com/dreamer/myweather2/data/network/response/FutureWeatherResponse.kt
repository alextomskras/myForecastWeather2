package com.dreamer.myweather2.data.network.response

import com.dreamer.myweather2.data.db.entity.FutureWeatherEntry
import com.dreamer.myweather2.data.db.entity.WeatherLocation
import com.google.gson.annotations.SerializedName

data class FutureWeatherResponse(
        @SerializedName("list")
        val futureWeatherEntries: List<FutureWeatherEntry>,
//        val entries: List<FutureWeatherEntry>
        val location: WeatherLocation
)