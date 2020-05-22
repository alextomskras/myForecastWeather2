package com.dreamer.myweather2.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dreamer.myweather2.data.network.response.OpenCurrentWeatherResponse


@Dao
interface CurrentWeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(weatherEntry: OpenCurrentWeatherResponse)
//    fun upsert(weatherEntry: List<WeatherEntry?>?)

    //    @Query("select * from main_coord_entry where id = $MAIN_CURRENT_WEATHER_ID")
    @Query("select * from root_weather_entry")
    fun getWeatherMetric(): LiveData<OpenCurrentWeatherResponse>
//    fun getWeatherMetric(): LiveData<MetricCurrentWeatherEntry>


    //    @Query("select * from main_coord_entry where id = $MAIN_CURRENT_WEATHER_ID")
    @Query("select * from root_weather_entry")
    fun getWeatherImperial(): LiveData<OpenCurrentWeatherResponse>
//    fun getWeatherImperial(): LiveData<ImperialCurrentWeatherEntry>
}