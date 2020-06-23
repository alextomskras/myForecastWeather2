package com.dreamer.myweather2.data.db.unitlocalized.future.list

import androidx.room.ColumnInfo
import com.dreamer.myweather2.data.db.entity.furute.Weather
import org.threeten.bp.LocalDateTime


class ImperialSimpleFutureWeatherEntry(
        @ColumnInfo(name = "dtTxt")
        override val date: LocalDateTime,
//        @ColumnInfo(name = "city_coord_lat")
        @ColumnInfo(name = "main_temp")
        override val avgTemperature: Double,
        @ColumnInfo(name = "weather")
        override val conditionText: List<Weather>,
        @ColumnInfo(name = "clouds_all")
        override val conditionIconUrl: Double
) : UnitSpecificSimpleFutureWeatherEntry