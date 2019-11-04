package com.dreamer.myweather2.data.db.unitlocalized.future.list

import androidx.room.ColumnInfo
import org.threeten.bp.LocalDate


data class MetricSimpleFutureWeatherEntry(
        @ColumnInfo(name = "date")
        override val date: LocalDate,
        @ColumnInfo(name = "avgtempC")
        override val avgTemperature: Double,
        @ColumnInfo(name = "weatherDescriptions")
        override val conditionText: String,
        @ColumnInfo(name = "weatherIcons")
        override val conditionIconUrl: String
) : UnitSpecificSimpleFutureWeatherEntry