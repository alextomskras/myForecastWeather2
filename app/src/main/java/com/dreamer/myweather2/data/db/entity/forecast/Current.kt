package com.dreamer.myweather2.data.db.entity.forecast


import com.google.gson.annotations.SerializedName

data class Current(
        val cloudcover: Int = 0, // 0
        val feelslike: Int = 0, // 24
        val humidity: Int = 0, // 19
        @SerializedName("is_day")
        val isDay: String = "", // yes
        @SerializedName("observation_time")
        val observationTime: String = "", // 06:58 PM
        val precip: Int = 0, // 0
        val pressure: Int = 0, // 1015
        val temperature: Int = 0, // 25
        @SerializedName("uv_index")
        val uvIndex: Int = 0, // 7
        val visibility: Int = 0, // 16
        @SerializedName("weather_code")
        val weatherCode: Int = 0, // 113
        @SerializedName("weather_descriptions")
        val weatherDescriptions: List<String> = listOf(),
        @SerializedName("weather_icons")
        val weatherIcons: List<String> = listOf(),
        @SerializedName("wind_degree")
        val windDegree: Int = 0, // 0
        @SerializedName("wind_dir")
        val windDir: String = "", // N
        @SerializedName("wind_speed")
        val windSpeed: Int = 0 // 0
)