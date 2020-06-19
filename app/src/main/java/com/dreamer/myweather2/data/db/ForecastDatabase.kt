package com.dreamer.myweather2.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
//import com.dreamer.myweather2.data.db.entity.FutureWeatherEntry
import com.dreamer.myweather2.data.db.entity.WeatherLocation
import com.dreamer.myweather2.data.db.entity.furute.X_Converter
import com.dreamer.myweather2.data.db.entity.furute.X_future
//import com.dreamer.myweather2.data.db.entity.X_Converter
import com.dreamer.myweather2.data.db.entity.openweatherapi.Coord
import com.dreamer.myweather2.data.network.response.MainConverter
import com.dreamer.myweather2.data.network.response.OpenCurrentWeatherResponse


@Database(
        entities = [
            WeatherLocation::class,
            Coord::class,
            OpenCurrentWeatherResponse::class,
            X_future::class
        ],
        version = 1
)
@TypeConverters(LocalDateConverter::class, MainConverter::class, X_Converter::class, X_Converter.WeatherConverter::class)
abstract class ForecastDatabase : RoomDatabase() {
    abstract fun currentWeatherDao(): CurrentWeatherDao
    abstract fun futureWeatherDao(): FutureWeatherDao
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
                        .setJournalMode(JournalMode.AUTOMATIC)
                        .build()
    }
}