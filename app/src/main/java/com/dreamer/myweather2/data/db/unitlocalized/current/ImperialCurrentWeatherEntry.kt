package com.dreamer.myweather2.data.db.unitlocalized.current

import androidx.room.ColumnInfo

//"https://assets.weatherstack.com/images/wsymbols01_png_64/wsymbol_0008_clear_sky_night.png"

data class ImperialCurrentWeatherEntry(
        @ColumnInfo(name = "temperature")
        override val temperature: Double,
        @ColumnInfo(name = "weatherDescriptions")
        override val conditionText: String,
        @ColumnInfo(name = "weatherIcons")
        override val conditionIconUrl: String,
        @ColumnInfo(name = "windMph")
        override val windSpeed: Double,
        @ColumnInfo(name = "windDir")
        override val windDirection: String,
        @ColumnInfo(name = "precip")
        override val precipitationVolume: Double,
        @ColumnInfo(name = "feelslike")
        override val feelsLikeTemperature: Double,
        @ColumnInfo(name = "visibility")
        override val visibilityDistance: Double
) : UnitSpecificCurrentWeatherEntry