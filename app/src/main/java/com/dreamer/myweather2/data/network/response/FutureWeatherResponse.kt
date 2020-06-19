package com.dreamer.myweather2.data.network.response

import androidx.room.Embedded

import com.dreamer.myweather2.data.db.entity.WeatherLocation
import com.dreamer.myweather2.data.db.entity.furute.City
import com.dreamer.myweather2.data.db.entity.furute.X_future
import com.google.gson.annotations.SerializedName

data class FutureWeatherResponse(
        var cod: String, // 200
        var message: Double, // 0.0032
        var cnt: Int, // 36
        @SerializedName("list")
//        val futureWeatherEntries: List<FutureWeatherEntry>,
        val futureWeatherEntries: List<X_future>,
//        val entries: List<FutureWeatherEntry>
        @SerializedName("city")
        @Embedded(prefix = "city_")
        var city: City,

        val location: WeatherLocation
)