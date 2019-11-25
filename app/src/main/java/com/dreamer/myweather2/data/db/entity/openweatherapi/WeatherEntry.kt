package com.dreamer.myweather2.data.db.entity.openweatherapi

//const val OPEN_CURRENT_WEATHER_ID = 0

//@Entity(tableName = "weather_entry")
data class WeatherEntry(
        var description: String, // broken clouds
        var icon: String, // 04n
//        val id: Int = 0, // 803
        var main: String // Clouds
)
//{
//    @PrimaryKey(autoGenerate = false)
//    var id: Int = OPEN_CURRENT_WEATHER_ID
//}