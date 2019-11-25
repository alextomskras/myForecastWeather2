package com.dreamer.myweather2.data.db.unitlocalized.current

import androidx.room.ColumnInfo


data class MetricCurrentWeatherEntry(
        @ColumnInfo(name = "main_temp")
        override val temperature: Double,
        @ColumnInfo(name = "base")
        override val conditionText: String,
//        @ColumnInfo(name = "weatherIcons")
//        override val conditionIconUrl: String,
//        @ColumnInfo(name = "windSpeed")
//        override val windSpeed: Double,
//        @ColumnInfo(name = "windDir")
//        override val windDirection: String,
        @ColumnInfo(name = "main_pressure")
        override val precipitationVolume: Int,
//        @ColumnInfo(name = "feelslike")
//        override val feelsLikeTemperature: Double,
        @ColumnInfo(name = "main_humidity")
        override val visibilityDistance: Double
) : UnitSpecificCurrentWeatherEntry