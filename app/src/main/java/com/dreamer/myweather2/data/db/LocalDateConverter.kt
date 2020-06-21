package com.dreamer.myweather2.data.db

import android.util.Log
import androidx.room.TypeConverter
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter


object LocalDateConverter {
    @TypeConverter
    @JvmStatic
    fun stringToDate(str: String?) = str?.let {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        Log.e("LocalDateConverter", "LocalDateConverter: $str")
        LocalDateTime.parse(it, formatter)
    }

    @TypeConverter
    @JvmStatic
    fun dateToString(dateTime: LocalDateTime?) = dateTime?.let {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
//        it.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
        it.format(formatter)
    }


}