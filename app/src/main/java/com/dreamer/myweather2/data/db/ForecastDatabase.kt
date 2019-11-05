package com.dreamer.myweather2.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dreamer.myweather2.data.db.entity.CurrentWeatherEntry
import com.dreamer.myweather2.data.db.entity.ListStringConverter
import com.dreamer.myweather2.data.db.entity.WeatherLocation


@Database(
        entities = [CurrentWeatherEntry::class, WeatherLocation::class],
        version = 1
)
@TypeConverters(LocalDateConverter::class, ListStringConverter::class)
abstract class ForecastDatabase : RoomDatabase() {
    abstract fun currentWeatherDao(): CurrentWeatherDao
    //    abstract fun futureWeatherDao(): FutureWeatherDao
    abstract fun weatherLocationDao(): WeatherLocationDao

    companion object {
        @Volatile
        private var instance: ForecastDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        ForecastDatabase::class.java, "futureWeatherEntries.db")
                        .build()
    }
}