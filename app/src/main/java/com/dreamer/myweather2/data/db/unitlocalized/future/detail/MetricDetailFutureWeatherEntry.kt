package com.dreamer.myweather2.data.db.unitlocalized.future.detail

import androidx.room.ColumnInfo
import com.dreamer.myweather2.data.db.entity.furute.Weather
import org.threeten.bp.LocalDateTime


data class MetricDetailFutureWeatherEntry(
        @ColumnInfo(name = "dtTxt")
        override val date: LocalDateTime,

        @ColumnInfo(name = "dt")
        override val dt: Int,
//        @ColumnInfo(name = "maxtempC")
        @ColumnInfo(name = "main_tempMax")
        override val maxTemperature: Double,
        @ColumnInfo(name = "main_tempMin")
        override val minTemperature: Double,
        @ColumnInfo(name = "main_temp")
        override val avgTemperature: Double,
        @ColumnInfo(name = "weather")
        override val conditionText: List<Weather>,
//        @ColumnInfo(name = "weatherIcons")
//        override val conditionIconUrl: String,
        @ColumnInfo(name = "wind_speed")
        override val maxWindSpeed: Double,
        @ColumnInfo(name = "main_pressure")
        override val totalPressure: Double
//        @ColumnInfo(name = "avgvisKm")
//        override val avgVisibilityDistance: Double,
//        @ColumnInfo(name = "uv")
//        override val uv: Double
) : UnitSpecificDetailFutureWeatherEntry