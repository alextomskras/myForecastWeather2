package com.dreamer.myweather2.data.db.entity

import android.util.Log
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListStringConverter {

    @TypeConverter
    fun fromString(value: String): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        Log.d(this@ListStringConverter.toString(), "fromString with error code: $String")
        return Gson().fromJson(value, listType)

    }

    @TypeConverter
    fun fromListLisr(list: List<String>): String {
        val gson = Gson()
        Log.d(this@ListStringConverter.toString(), "fromListLisr with1 error code: ${list.last()}")
        return gson.toJson(list.last()
        )
    }

//    class ReposPersistentConverter {
//        @TypeConverter
//        fun fromString(value: String?): List<WeatherEntry?>? = Gson().fromJson(value, object : TypeToken<List<WeatherEntry?>?>() {}.type)
//
//        @TypeConverter
//        fun fromModel(value: List<WeatherEntry?>?): String? = Gson().toJson(value)
//
//    }

//    class MainConverter {
//        @TypeConverter
//        fun froString(value: String?): List<Mainnnn2?>? = Gson().fromJson(value, object : TypeToken<List<Mainnnn2?>?>() {}.type)
//
//        @TypeConverter
//        fun fromMode(value: List<Mainnnn2?>?): String? = Gson().toJson(value)
//
//    }

}