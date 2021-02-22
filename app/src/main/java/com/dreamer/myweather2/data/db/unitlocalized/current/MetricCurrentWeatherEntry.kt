package com.dreamer.myweather2.data.db.unitlocalized.current

import androidx.room.ColumnInfo
import com.dreamer.myweather2.data.db.entity.openweatherapi.WeatherEntry


data class MetricCurrentWeatherEntry(
        @ColumnInfo(name = "main_temp")
        override val temperature: Double,
        @ColumnInfo(name = "main_tempMax")
        override val temperatureMax: Double,
        @ColumnInfo(name = "main_tempMin")
        override val temperatureMin: Double,
        @ColumnInfo(name = "weather")
        override val conditionText: List<WeatherEntry>,
//        @ColumnInfo(name = "base")
//        override val conditionText: String,
//        @ColumnInfo(name = "weatherIcons")
//        override val conditionIconUrl: String,
        @ColumnInfo(name = "wind_speed")
        override val windSpeed: Double,
        @ColumnInfo(name = "wind_deg")
        override val windDirection: String,
        @ColumnInfo(name = "main_pressure")
        override val precipitationVolume: Int,
        @ColumnInfo(name = "main_feelslike")
        override val feelsLikeTemperature: Double,
        @ColumnInfo(name = "sys_sunrise")
        override val sysSunrise: Double,
        @ColumnInfo(name = "sys_sunset")
        override val sysSunset: Double,
        @ColumnInfo(name = "visibility")
        override val visibilityDistance: Double
) : UnitSpecificCurrentWeatherEntry