package com.resocoder.myweather2.data.network.response

import com.google.gson.annotations.SerializedName
import com.resocoder.myweather2.data.db.entity.FutureWeatherEntry

data class ForecastDaysContainer(
        @SerializedName("forecastday")
        val entries: List<FutureWeatherEntry>
)