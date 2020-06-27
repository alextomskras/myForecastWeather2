package com.dreamer.myweather2.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dreamer.myweather2.data.db.entity.furute.X_future
import com.dreamer.myweather2.data.db.unitlocalized.future.detail.ImperialDetailFutureWeatherEntry
import com.dreamer.myweather2.data.db.unitlocalized.future.detail.MetricDetailFutureWeatherEntry
import com.dreamer.myweather2.data.db.unitlocalized.future.list.ImperialSimpleFutureWeatherEntry
import com.dreamer.myweather2.data.db.unitlocalized.future.list.MetricSimpleFutureWeatherEntry
import org.threeten.bp.LocalDateTime


@Dao
interface FutureWeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insert(futureWeatherEntries: List<FutureWeatherEntry>)
//    fun insert(X_future: List<X_future>)
    fun insert(futureWeatherEntries: List<X_future>)

    //    @Query("select * from future_weather where date(date) >= date(:startDate)")
//    @Query("select * from future_weather where date(dtTxt) >= date(:startDate)")
//    select *, name from future_weather,root_weather_entry
    @Query("select * from future_weather where date(dtTxt) >= date(:startDate) ")
//    @Transaction
//    @Query("select root_weather_entry.name, future_weather.*  from future_weather, root_weather_entry where date(dtTxt) >= date(:startDate) ")

//    fun getSimpleWeatherForecastsMetric(startDate: LocalDate): LiveData<List<MetricSimpleFutureWeatherEntry>>
    fun getSimpleWeatherForecastsMetric(startDate: LocalDateTime): LiveData<List<MetricSimpleFutureWeatherEntry>>

    //    @Query("select * from future_weather where date(date) >= date(:startDate)")
//    @Query("select * from future_weather where date(dtTxt) >= date(:startDate)")
//    @Query("select * from future_weather where date(dtTxt) >= date(:startDate)")
    @Query("select root_weather_entry.name, future_weather.* from future_weather, root_weather_entry where date(dtTxt) >= date(:startDate) ")
    fun getSimpleWeatherForecastsImperial(startDate: LocalDateTime): LiveData<List<ImperialSimpleFutureWeatherEntry>>

    //    @Query("select * from future_weather where date(date) = date(:date)")
    @Query("select * from future_weather where dt = (:epocheMill)")
    fun getDetailedWeatherByDateMetric(epocheMill: Int): LiveData<MetricDetailFutureWeatherEntry>

    //    @Query("select * from future_weather where date(date) = date(:date)")
    @Query("select * from future_weather where date(dtTxt ) = date(:date)")
    fun getDetailedWeatherByDateImperial(date: LocalDateTime): LiveData<ImperialDetailFutureWeatherEntry>

    //    @Query("select count(id) from future_weather where date(date) >= date(:startDate)")
//    @Query("select count(id) from future_weather where date(dtTxt) >= date(:startDate)")
    @Query("select count(id) from future_weather where date(:startDate)")
    fun countFutureWeather(startDate: LocalDateTime): Int

    //    @Query("delete from future_weather where date(date) < date(:firstDateToKeep)")
    @Query("delete from future_weather where date(dtTxt) < date(:firstDateToKeep)")
    fun deleteOldEntries(firstDateToKeep: LocalDateTime)
}