package com.dreamer.myweather2.data.db.unitlocalized.future.detail

import androidx.room.ColumnInfo
import org.threeten.bp.LocalDate


data class ImperialDetailFutureWeatherEntry(
        @ColumnInfo(name = "dtTxt")
        override val date: LocalDate,
        @ColumnInfo(name = "main_tempMax")
        override val maxTemperature: Double
//        @ColumnInfo(name = "mintempF")
//        override val minTemperature: Double,
//        @ColumnInfo(name = "avgtempF")
//        override val avgTemperature: Double,
//        @ColumnInfo(name = "weatherDescriptions")
//        override val conditionText: String,
//        @ColumnInfo(name = "weatherIcons")
//        override val conditionIconUrl: String,
//        @ColumnInfo(name = "maxwindMph")
//        override val maxWindSpeed: Double,
//        @ColumnInfo(name = "totalprecipIn")
//        override val totalPrecipitation: Double,
//        @ColumnInfo(name = "avgvisMiles")
//        override val avgVisibilityDistance: Double,
//        @ColumnInfo(name = "uv")
//        override val uv: Double
) : UnitSpecificDetailFutureWeatherEntry