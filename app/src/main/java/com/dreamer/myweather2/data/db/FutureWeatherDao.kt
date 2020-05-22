package com.dreamer.myweather2.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dreamer.myweather2.data.db.entity.FutureWeatherEntry
import com.dreamer.myweather2.data.db.unitlocalized.future.detail.ImperialDetailFutureWeatherEntry
import com.dreamer.myweather2.data.db.unitlocalized.future.detail.MetricDetailFutureWeatherEntry
import com.dreamer.myweather2.data.db.unitlocalized.future.list.ImperialSimpleFutureWeatherEntry
import com.dreamer.myweather2.data.db.unitlocalized.future.list.MetricSimpleFutureWeatherEntry
import org.threeten.bp.LocalDate

@Dao
interface FutureWeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insert(futureWeatherEntries: List<FutureWeatherEntry>)
    fun insert(futureWeatherEntries: FutureWeatherEntry)

    //    @Query("select * from future_weather where date(date) >= date(:startDate)")
    @Query("select * from future_weather where date(dt) >= date(:startDate)")

    fun getSimpleWeatherForecastsMetric(startDate: LocalDate): LiveData<List<MetricSimpleFutureWeatherEntry>>

    //    @Query("select * from future_weather where date(date) >= date(:startDate)")
    @Query("select * from future_weather where date(dt) >= date(:startDate)")
    fun getSimpleWeatherForecastsImperial(startDate: LocalDate): LiveData<List<ImperialSimpleFutureWeatherEntry>>

    //    @Query("select * from future_weather where date(date) = date(:date)")
    @Query("select * from future_weather where date(dt) = date(:date)")
    fun getDetailedWeatherByDateMetric(date: LocalDate): LiveData<MetricDetailFutureWeatherEntry>

    //    @Query("select * from future_weather where date(date) = date(:date)")
    @Query("select * from future_weather where date(dt) = date(:date)")
    fun getDetailedWeatherByDateImperial(date: LocalDate): LiveData<ImperialDetailFutureWeatherEntry>

    //    @Query("select count(id) from future_weather where date(date) >= date(:startDate)")
    @Query("select count(id) from future_weather where date(dt) >= date(:startDate)")
    fun countFutureWeather(startDate: LocalDate): Int

    //    @Query("delete from future_weather where date(date) < date(:firstDateToKeep)")
    @Query("delete from future_weather where date(dt) < date(:firstDateToKeep)")
    fun deleteOldEntries(firstDateToKeep: LocalDate)
}