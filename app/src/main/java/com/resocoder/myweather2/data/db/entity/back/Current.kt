package com.resocoder.myweather2.data.db.entity.back


import com.google.gson.annotations.SerializedName

data class Current(
        val cloudcover: Int, // 0
        val feelslike: Int, // 25
        val humidity: Int, // 7
        @SerializedName("is_day")
        val isDay: String, // yes
        @SerializedName("observation_time")
        val observationTime: String, // 08:29 PM
        val precip: Int, // 0
        val pressure: Int, // 1018
        val temperature: Int, // 27
        @SerializedName("uv_index")
        val uvIndex: Int, // 7
        val visibility: Int, // 16
        @SerializedName("weather_code")
        val weatherCode: Int, // 113
        @SerializedName("weather_descriptions")
        val weatherDescriptions: List<String>,
        @SerializedName("weather_icons")
        val weatherIcons: List<String>,
        @SerializedName("wind_degree")
        val windDegree: Int, // 0
        @SerializedName("wind_dir")
        val windDir: String, // N
        @SerializedName("wind_speed")
        val windSpeed: Int // 0
)