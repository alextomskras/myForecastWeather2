package com.dreamer.myweather2.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dreamer.myweather2.data.db.unitlocalized.current.ImperialCurrentWeatherEntry
import com.dreamer.myweather2.data.db.unitlocalized.current.MetricCurrentWeatherEntry
import com.dreamer.myweather2.data.network.response.OpenCurrentWeatherResponse
import com.dreamer.myweather2.data.network.response.ROOT_CURRENT_WEATHER_ID


@Dao
interface RootCurrentWeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(weatherRootEntry: OpenCurrentWeatherResponse)

    @Query("select * from root_weather_entry where id = $ROOT_CURRENT_WEATHER_ID")
    fun getRootWeatherMetric(): LiveData<MetricCurrentWeatherEntry>

    @Query("select * from root_weather_entry where id = $ROOT_CURRENT_WEATHER_ID")
    fun getRootWeatherImperial(): LiveData<ImperialCurrentWeatherEntry>
}