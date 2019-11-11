package com.dreamer.myweather2.data.network.response

import com.dreamer.myweather2.data.db.entity.openweatherapi.WeatherEntry
import com.google.gson.annotations.SerializedName

data class WeatherDayContainer(
        @SerializedName("forecastday")
        val entries: List<WeatherEntry>
)