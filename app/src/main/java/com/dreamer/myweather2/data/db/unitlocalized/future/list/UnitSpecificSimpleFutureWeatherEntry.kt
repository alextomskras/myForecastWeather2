package com.dreamer.myweather2.data.db.unitlocalized.future.list

import android.os.Parcelable
import com.dreamer.myweather2.data.db.entity.furute.Weather
import org.threeten.bp.LocalDateTime


interface UnitSpecificSimpleFutureWeatherEntry : Parcelable {
    val date: LocalDateTime
    val avgTemperature: Double
    val conditionText: List<out (Weather)>
    val conditionIconUrl: Double
    override fun describeContents(): Int
//    val name: String
}