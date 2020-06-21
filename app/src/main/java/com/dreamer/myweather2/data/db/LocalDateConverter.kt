package com.dreamer.myweather2.data.db

import android.util.Log
import androidx.room.TypeConverter
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter


object LocalDateConverter {
    @TypeConverter
    @JvmStatic
    fun stringToDate(str: String?) = str?.let {
        Log.e("LocalDateConverter", "LocalDateConverter: $str")
        LocalDate.parse(it, DateTimeFormatter.BASIC_ISO_DATE)
    }

    @TypeConverter
    @JvmStatic
    fun dateToString(dateTime: LocalDate?) = dateTime?.format(DateTimeFormatter.BASIC_ISO_DATE)

}