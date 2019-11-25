package com.dreamer.myweather2.data.db.entity.openweatherapi

import com.google.gson.annotations.SerializedName


data class Main(
        @SerializedName("humidity")
        val humidity: Int, // 100
        @SerializedName("pressure")
        val pressure: Int, // 1013
        @SerializedName("temp")
        val temp: Double, // 279.52
        @SerializedName("temp_max")
        val tempMax: Double, // 280.93
        @SerializedName("temp_min")
        val tempMin: Double // 278.15

)
