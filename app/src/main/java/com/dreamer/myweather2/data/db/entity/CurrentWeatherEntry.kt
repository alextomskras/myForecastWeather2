package com.dreamer.myweather2.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import org.threeten.bp.DayOfWeek

const val CURRENT_WEATHER_ID = 0

@Entity(tableName = "current_weather")
@TypeConverters(ListStringConverter::class)
data class CurrentWeatherEntry(
        @SerializedName("temp_c")
        val tempC: Double,
        @SerializedName("temp_f")
        val tempF: Double,
        @SerializedName("observation_time")
        val observationTime: String, // 08:29 PM
        @SerializedName("uv_index")
        val uvIndex: Int, // 7
        @SerializedName("is_day")
        val isDay: String,
        @SerializedName("weather_code")
        val weatherCode: Int, // 113
//    @Embedded(prefix = "condition_")
//    val condition: Condition,
//    @SerializedName("request")
//    @Embedded(prefix = "request_")
//    val request: Request,
        @SerializedName("wind_mph")
        val windMph: Double,
        @SerializedName("wind_kph")
        val windKph: Double,
        @SerializedName("wind_dir")
        val windDir: String,
        @SerializedName("wind_degree")
        val windDegree: Int, // 0
        @SerializedName("wind_speed")
        val windSpeed: Int, // 0
        @SerializedName("precip_mm")
        val precipMm: Double,
        @SerializedName("cloudcover")
        val cloudcover: Double,
        @SerializedName("precip_in")
        val precipIn: Double,
        @SerializedName("temperature")
        val temperature: Int, // 27
        @SerializedName("feelslike_c")
        val feelslikeC: Double,
        @SerializedName("feelslike_f")
        val feelslikeF: Double,
        @SerializedName("vis_km")
        val visKm: Double,
        @SerializedName("weather_descriptions")
        val weatherDescriptions: List<String>,

//    @SerializedName("weather_descriptions")
//    val weatherDescriptions: List<weatherDescrEntry>,
//    @SerializedName("weather_icons")
//    val weatherIcons: List<weatherIconEntry>,
        @SerializedName("weather_icons")
        val weatherIcons: List<String>,
        @SerializedName("vis_miles")
        val visMiles: Double
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = CURRENT_WEATHER_ID
}

private const val SEPARATOR = ","

class DayOfWeekConverter {
    companion object {

        @TypeConverter
        @JvmStatic
        fun daysOfWeekToString(daysOfWeek: MutableList<DayOfWeek>?): String? =
                daysOfWeek?.map { it.value }?.joinToString(separator = SEPARATOR)

        @TypeConverter
        @JvmStatic
        fun stringToDaysOfWeek(daysOfWeek: String?): MutableList<DayOfWeek>? =
                daysOfWeek?.split(SEPARATOR)?.map { DayOfWeek.of(it.toInt()) }?.toMutableList()
    }
}
