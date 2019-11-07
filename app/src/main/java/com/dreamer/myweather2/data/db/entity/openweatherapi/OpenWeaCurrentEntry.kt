package com.dreamer.myweather2.data.db.entity.openweatherapi


data class OpenWeaCurrentEntry(
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
        val weather: List<Weather> = listOf(),
        val wind: Wind = Wind()
)