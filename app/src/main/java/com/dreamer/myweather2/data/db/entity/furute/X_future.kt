package com.dreamer.myweather2.data.db.entity.furute


import android.util.Log
import androidx.room.*
import com.dreamer.myweather2.data.db.entity.openweatherapi.Coord
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken

const val FUTURENT_WEATHER_ID = 0

@Entity(tableName = "future_weather", indices = [Index(value = ["dtTxt"], unique = true)])

@TypeConverters(
        X_Converter::class,
        X_Converter.WeatherConverter::class,
        X_Converter.CoordConverter::class,
//        SysConverter::class,
        X_Converter.MainConverter::class
)


data class X_future(
        @PrimaryKey(autoGenerate = true)
        var id: Int? = null,
        var dt: Int, // 1487624400
        @SerializedName("main")
        @Embedded(prefix = "main_")
        var main: Main,
        @SerializedName("weather")
        var weather: List<Weather>,
        @SerializedName("clouds")
        @Embedded(prefix = "clouds_")
        var clouds: Clouds,
        @SerializedName("wind")
        @Embedded(prefix = "wind_")
        var wind: Wind,
        @SerializedName("sys")
        @Embedded(prefix = "sys_")
        var sys: Sys,
        @SerializedName("dt_txt")
        var dtTxt: String, // 2017-02-20 21:00:00
        @SerializedName("rain")
        @Embedded(prefix = "rain_")
        var rain: Rain,
        @SerializedName("snow")
        @Embedded(prefix = "snow_")
        var snow: Snow
) {

//    @PrimaryKey(autoGenerate = false)
//    var id: Int = FUTURENT_WEATHER_ID
}

class X_Converter {
    @TypeConverter
    fun fromString(value: String): List<X_future> {
        Log.e(this@X_Converter.toString(), "FutureList1: ${value.last()}")
        return Gson().fromJson(value, object : TypeToken<List<X_future>>() {}.type)
    }

    @TypeConverter
    fun fromJson(value: List<X_future>): String {
        Log.e(this@X_Converter.toString(), "futureList2: ${value.last()}")
        return Gson().toJson(value)
    }

    class CoordConverter {
        @TypeConverter
        fun fromString(value: String?): List<Coord?>? = Gson().fromJson(value, object : TypeToken<List<Coord?>?>() {}.type)

        @TypeConverter
        fun fromJson(value: List<Coord?>?): String? = Gson().toJson(value)

    }

    class WeatherConverter {
        @TypeConverter
        fun fromString(value: String): List<Weather> {
            Log.e(this@WeatherConverter.toString(), "WeatherConverter_fromerror1: ${value.last()}")
            return Gson().fromJson(value, object : TypeToken<List<Weather>>() {}.type)
        }

        @TypeConverter
        fun fromJson(value: List<Weather>): String {
            Log.e(this@WeatherConverter.toString(), "WeatherConverter_fromerror2: ${value.last()}")
            return Gson().toJson(value)
        }

    }

    class MainConverter {
        @TypeConverter
        fun fromString1(value: String): List<com.dreamer.myweather2.data.db.entity.openweatherapi.Main> = Gson().fromJson(value, object : TypeToken<List<com.dreamer.myweather2.data.db.entity.openweatherapi.Main>>() {}.type)

        @TypeConverter
        fun fromJson(value: List<com.dreamer.myweather2.data.db.entity.openweatherapi.Main>): String? = Gson().toJson(value)

    }
//class SysConverter {
//        @TypeConverter
//        fun fromString1(value: String): List<Sys> = Gson().fromJson(value, object : TypeToken<List<Sys>>() {}.type)
//
//        @TypeConverter
//        fun fromJson(value: List<Sys>): String? = Gson().toJson(value)
//
//}
}