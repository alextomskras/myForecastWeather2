package com.dreamer.myweather2.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dreamer.myweather2.data.db.entity.openweatherapi.COORD_CURRENT_WEATHER_ID
import com.dreamer.myweather2.data.db.entity.openweatherapi.Coord


@Dao
interface WeatherLocationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(weatherLocation: Coord)

    @Query("select * from coord_entry where id = $COORD_CURRENT_WEATHER_ID")
    fun getLocation(): LiveData<Coord>

    @Query("select * from coord_entry where id = $COORD_CURRENT_WEATHER_ID")
    fun getLocationNonLive(): Coord?
}