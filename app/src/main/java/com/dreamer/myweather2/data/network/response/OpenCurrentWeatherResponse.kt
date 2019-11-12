package com.dreamer.myweather2.data.network.response

import com.dreamer.myweather2.data.db.entity.openweatherapi.*
import com.google.gson.annotations.SerializedName


data class OpenCurrentWeatherResponse(
        val base: String, // stations
        val clouds: Clouds,
        val cod: Int, // 200
//        val coord: Coord = Coord(),
        val dt: Int, // 1573150768
        val id: Int, // 524901
        val main: Main,
        val name: String, // Moscow
        val sys: Sys,
        val timezone: Int, // 10800
        val visibility: Int, // 10000
        @SerializedName("weather")
//        val weather: WeatherDayContainer,
        val weather: List<WeatherEntry>,
//        val location: WeatherLocation,
        @SerializedName("coord")
        val location: Coord,
        val wind: Wind
)