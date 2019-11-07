package com.dreamer.myweather2.data.db.entity.openweatherapi


data class Weather(
        val description: String = "", // broken clouds
        val icon: String = "", // 04n
        val id: Int = 0, // 803
        val main: String = "" // Clouds
)