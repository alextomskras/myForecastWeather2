package com.dreamer.myweather2.data.network.response

import androidx.room.Embedded
import com.dreamer.myweather2.data.db.entity.openweatherapi.*
import com.google.gson.annotations.SerializedName

const val ROOT_CURRENT_WEATHER_ID = 0

//@Entity(tableName = "root_weather_entry")
//@TypeConverters(ListStringConverter::class)
data class OpenCurrentWeatherResponse(
        val base: String, // stations
        @Embedded(prefix = "clouds_")
        val clouds: Clouds,
        val cod: Int, // 200
//        val coord: Coord = Coord(),
        val dt: Int, // 1573150768
//        val id: Int, // 524901
        @Embedded(prefix = "main_")
        val main: Main,
        @SerializedName("name")
        val name: String, // Moscow
        @Embedded(prefix = "sys_")
        val sys: Sys,
        val timezone: Int, // 10800
        val visibility: Int, // 10000
//        @SerializedName("weather")
//        val weather: WeatherDayContainer,
//        @Embedded( prefix = "weath_")
//        val weather: List<WeatherEntry>?,
//        val weather: Main?,
        @SerializedName("coord")
        @Embedded(prefix = "location_")
        val location: Coord,
        @Embedded(prefix = "wind_")
        val wind: Wind
)
//{
//        @PrimaryKey(autoGenerate = false)
//        var id: Int = ROOT_CURRENT_WEATHER_ID
//}