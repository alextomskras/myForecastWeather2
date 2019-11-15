package com.dreamer.myweather2.data.db.unitlocalized.current

import androidx.room.ColumnInfo


data class MetricCurrentWeatherEntry(
        @ColumnInfo(name = "temp")
        override val temperature: Double
//        @ColumnInfo(name = "weatherDescriptions")
//        override val conditionText: String,
//        @ColumnInfo(name = "weatherIcons")
//        override val conditionIconUrl: String,
//        @ColumnInfo(name = "windSpeed")
//        override val windSpeed: Double,
//        @ColumnInfo(name = "windDir")
//        override val windDirection: String,
//        @ColumnInfo(name = "precip")
//        override val precipitationVolume: Double,
//        @ColumnInfo(name = "feelslike")
//        override val feelsLikeTemperature: Double,
//        @ColumnInfo(name = "visibility")
//        override val visibilityDistance: Double
) : UnitSpecificCurrentWeatherEntry