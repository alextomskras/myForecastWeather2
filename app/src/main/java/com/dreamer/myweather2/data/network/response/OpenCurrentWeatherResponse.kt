package com.dreamer.myweather2.data.network.response

import com.dreamer.myweather2.data.db.entity.WeatherLocation
import com.dreamer.myweather2.data.db.entity.openweatherapi.*
import com.google.gson.annotations.SerializedName


data class OpenCurrentWeatherResponse(
        val base: String = "", // stations
        val clouds: Clouds = Clouds(),
        val cod: Int = 0, // 200
        val coord: Coord = Coord(),
        val dt: Int = 0, // 1573150768
        val id: Int = 0, // 524901
        val main: Main = Main(),
        val name: String = "", // Moscow
        val sys: Sys = Sys(),
        val timezone: Int = 0, // 10800
        val visibility: Int = 0, // 10000
        @SerializedName("weather")
//        val weather: WeatherDayContainer,
        val weather: List<WeatherEntry>,
        val location: WeatherLocation,
        val wind: Wind
)