package com.dreamer.myweather2.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dreamer.myweather2.data.db.entity.openweatherapi.MAIN_CURRENT_WEATHER_ID
import com.dreamer.myweather2.data.db.entity.openweatherapi.Main
import com.dreamer.myweather2.data.db.unitlocalized.current.ImperialCurrentWeatherEntry
import com.dreamer.myweather2.data.db.unitlocalized.current.MetricCurrentWeatherEntry


@Dao
interface CurrentWeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(weatherEntry: Main)
//    fun upsert(weatherEntry: List<WeatherEntry>?)

    @Query("select * from main_coord_entry where id = $MAIN_CURRENT_WEATHER_ID")
    fun getWeatherMetric(): LiveData<MetricCurrentWeatherEntry>

    @Query("select * from main_coord_entry where id = $MAIN_CURRENT_WEATHER_ID")
    fun getWeatherImperial(): LiveData<ImperialCurrentWeatherEntry>
}