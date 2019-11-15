package com.dreamer.myweather2.data.db.entity.openweatherapi


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


const val MAIN_CURRENT_WEATHER_ID = 0

@Entity(tableName = "main_coord_entry")

data class Main(
        val humidity: Int, // 100
        val pressure: Int, // 1013
        val temp: Double, // 279.52
        @SerializedName("temp_max")
        val tempMax: Double, // 280.93
        @SerializedName("temp_min")
        val tempMin: Double // 278.15
) {
        @PrimaryKey(autoGenerate = false)
        var id: Int = MAIN_CURRENT_WEATHER_ID
}