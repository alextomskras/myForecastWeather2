package com.dreamer.myweather2.data.db.entity

import android.util.Log
import androidx.room.*
import com.dreamer.myweather2.data.db.entity.furute.FutureRequest
import com.dreamer.myweather2.data.db.entity.furute.X
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity(tableName = "future_weather", indices = [Index(value = ["dt"], unique = true)])
@TypeConverters(
        X_Converter::class
//                CoordConverter::class,
////        SysConverter::class,
//                MainConverter::class
)
data class FutureWeatherEntry(

        @PrimaryKey(autoGenerate = true)
//        val id: Int? = null,
        val dt: String,
        @Embedded
        val day: FutureRequest
)

class X_Converter {
        @TypeConverter
        fun fromString(value: String): List<X> {
                Log.e(this@X_Converter.toString(), "FutureList1: ${value.last()}")
                return Gson().fromJson(value, object : TypeToken<List<X>>() {}.type)
        }

        @TypeConverter
        fun fromJson(value: List<X>): String {
                Log.e(this@X_Converter.toString(), "futureList2: ${value.last()}")
                return Gson().toJson(value)
        }

}