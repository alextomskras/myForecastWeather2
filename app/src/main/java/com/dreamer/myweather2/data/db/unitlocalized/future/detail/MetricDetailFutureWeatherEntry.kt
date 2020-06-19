package com.dreamer.myweather2.data.db.unitlocalized.future.detail

import androidx.room.ColumnInfo
import org.threeten.bp.LocalDate


data class MetricDetailFutureWeatherEntry(
        @ColumnInfo(name = "dt")
        override val date: LocalDate,
//        @ColumnInfo(name = "maxtempC")
        @ColumnInfo(name = "main_tempMax")
        override val maxTemperature: Double
//        @ColumnInfo(name = "mintempC")
//        override val minTemperature: Double,
//        @ColumnInfo(name = "avgtempC")
//        override val avgTemperature: Double,
//        @ColumnInfo(name = "weatherDescriptions")
//        override val conditionText: String,
//        @ColumnInfo(name = "weatherIcons")
//        override val conditionIconUrl: String,
//        @ColumnInfo(name = "maxwindKph")
//        override val maxWindSpeed: Double,
//        @ColumnInfo(name = "totalprecipMm")
//        override val totalPrecipitation: Double,
//        @ColumnInfo(name = "avgvisKm")
//        override val avgVisibilityDistance: Double,
//        @ColumnInfo(name = "uv")
//        override val uv: Double
) : UnitSpecificDetailFutureWeatherEntry