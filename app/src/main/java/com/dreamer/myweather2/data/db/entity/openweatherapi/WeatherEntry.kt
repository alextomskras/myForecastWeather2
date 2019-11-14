package com.dreamer.myweather2.data.db.entity.openweatherapi

import androidx.room.Entity
import androidx.room.PrimaryKey

const val OPEN_CURRENT_WEATHER_ID = 0

@Entity(tableName = "weather_entry")
data class WeatherEntry(
        val description: String?, // broken clouds
        val icon: String?, // 04n
//        val id: Int = 0, // 803
        val main: String? // Clouds
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = OPEN_CURRENT_WEATHER_ID
}