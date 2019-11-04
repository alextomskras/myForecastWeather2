package com.resocoder.myweather2.data.network.response

import com.google.gson.annotations.SerializedName
import com.resocoder.myweather2.data.db.entity.WeatherLocation

data class FutureWeatherResponse(
        @SerializedName("forecast")
        val futureWeatherEntries: ForecastDaysContainer,
        val location: WeatherLocation
)