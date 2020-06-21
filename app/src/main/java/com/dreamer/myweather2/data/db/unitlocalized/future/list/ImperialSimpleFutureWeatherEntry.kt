package com.dreamer.myweather2.data.db.unitlocalized.future.list

import androidx.room.ColumnInfo
import org.threeten.bp.LocalDate


class ImperialSimpleFutureWeatherEntry(
        @ColumnInfo(name = "dtTxt")
        override val date: LocalDate,
//        @ColumnInfo(name = "city_coord_lat")
        @ColumnInfo(name = "main_temp")
        override val avgTemperature: Double,
        @ColumnInfo(name = "dt")
        override val conditionText: Double,
        @ColumnInfo(name = "clouds_all")
        override val conditionIconUrl: Double
) : UnitSpecificSimpleFutureWeatherEntry