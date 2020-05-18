package com.dreamer.myweather2.data.db.entity.furute

import android.util.Log
import androidx.room.Embedded
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken


data class FutureRequest(
        @TypeConverters(
                X_Converter::class
//                CoordConverter::class,
////        SysConverter::class,
//                MainConverter::class
        )

        var cod: String, // 200
        var message: Double, // 0.0032
        var cnt: Int, // 36
        @SerializedName("list")
        var list: List<X>,
        @SerializedName("city")
        @Embedded(prefix = "city_")
        var city: City
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


