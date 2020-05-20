package com.dreamer.myweather2.data.db.unitlocalized.future.list

import androidx.room.ColumnInfo
import org.threeten.bp.LocalDate


class ImperialSimpleFutureWeatherEntry(
        @ColumnInfo(name = "dt")
        override val date: LocalDate,
        @ColumnInfo(name = "city_coord_lat")
        override val avgTemperature: Double,
        @ColumnInfo(name = "city_name")
        override val conditionText: String,
        @ColumnInfo(name = "message")
        override val conditionIconUrl: String
) : UnitSpecificSimpleFutureWeatherEntry