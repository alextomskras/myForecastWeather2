package com.dreamer.myweather2.data.db.entity.openweatherapi


import com.google.gson.annotations.SerializedName

data class Main(
        val humidity: Int = 0, // 100
        val pressure: Int = 0, // 1013
        val temp: Double = 0.0, // 279.52
        @SerializedName("temp_max")
        val tempMax: Double = 0.0, // 280.93
        @SerializedName("temp_min")
        val tempMin: Double = 0.0 // 278.15
)