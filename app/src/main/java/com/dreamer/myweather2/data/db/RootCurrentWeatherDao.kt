package com.dreamer.myweather2.data.db

//import androidx.lifecycle.LiveData
//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.OnConflictStrategy
//import androidx.room.Query
//import com.dreamer.myweather2.data.db.entity.openweatherapi.OPEN_CURRENT_WEATHER_ID
//import com.dreamer.myweather2.data.db.entity.openweatherapi.WeatherEntry
//import com.dreamer.myweather2.data.db.unitlocalized.current.ImperialCurrentWeatherEntry
//import com.dreamer.myweather2.data.db.unitlocalized.current.MetricCurrentWeatherEntry


//@Dao
//interface RootCurrentWeatherDao {
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun upsert(weatherRootEntry: List<WeatherEntry>)
//
//    @Query("select * from root_weather_entry where id = $OPEN_CURRENT_WEATHER_ID")
//    fun getRootWeatherMetric(): LiveData<MetricCurrentWeatherEntry>
//
//    @Query("select * from root_weather_entry where id = $OPEN_CURRENT_WEATHER_ID")
//    fun getRootWeatherImperial(): LiveData<ImperialCurrentWeatherEntry>
//}