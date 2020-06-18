package com.dreamer.myweather2.data.db.entity.furute


import androidx.room.Embedded
import com.google.gson.annotations.SerializedName

data class X_future(
        var dt: Int, // 1487624400
        @SerializedName("main")
        @Embedded(prefix = "main_")
        var main: Main,
        @SerializedName("futureWeather")
        var weather: List<Weather>,
        @SerializedName("clouds")
        @Embedded(prefix = "clouds_")
        var clouds: Clouds,
        @SerializedName("wind")
        @Embedded(prefix = "wind_")
        var wind: Wind,
        @SerializedName("sys")
        @Embedded(prefix = "sys_")
        var sys: Sys,
        @SerializedName("dt_txt")
        var dtTxt: String, // 2017-02-20 21:00:00
        @SerializedName("rain")
        @Embedded(prefix = "rain_")
        var rain: Rain,
        @SerializedName("snow")
        @Embedded(prefix = "snow_")
        var snow: Snow
)