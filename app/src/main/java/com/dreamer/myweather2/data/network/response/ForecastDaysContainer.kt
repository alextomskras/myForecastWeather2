package com.dreamer.myweather2.data.network.response

import com.dreamer.myweather2.data.db.entity.FutureWeatherEntry
import com.google.gson.annotations.SerializedName

data class ForecastDaysContainer(
        @SerializedName("list")
        val entries: List<FutureWeatherEntry>
)