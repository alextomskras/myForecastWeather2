package com.dreamer.myweather2.data.db.entity.furute


import androidx.room.Embedded
import com.google.gson.annotations.SerializedName

data class X_future(
        var dt: Int, // 1487624400
        @SerializedName("main")
        @Embedded(prefix = "main_")
        var main: Main,
        var weather: List<Weather>,
        var clouds: Clouds,
        var wind: Wind,
        var sys: Sys,
        @SerializedName("dt_txt")
        var dtTxt: String, // 2017-02-20 21:00:00
        var rain: Rain,
        var snow: Snow
)