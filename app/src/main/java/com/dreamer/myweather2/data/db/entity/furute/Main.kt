package com.dreamer.myweather2.data.db.entity.furute


import com.google.gson.annotations.SerializedName

data class Main(
        var temp: Double, // 272.424
        @SerializedName("temp_min")
        var tempMin: Double, // 272.424
        @SerializedName("temp_max")
        var tempMax: Double, // 272.424
        var pressure: Double, // 968.38
        @SerializedName("sea_level")
        var seaLevel: Double, // 1043.17
        @SerializedName("grnd_level")
        var grndLevel: Double, // 968.38
        var humidity: Int, // 85
        @SerializedName("temp_kf")
        var tempKf: Double // 0
)