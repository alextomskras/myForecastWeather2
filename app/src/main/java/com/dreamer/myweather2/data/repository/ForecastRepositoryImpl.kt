package com.dreamer.myweather2.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.dreamer.myweather2.data.db.CurrentWeatherDao
import com.dreamer.myweather2.data.db.WeatherLocationDao
import com.dreamer.myweather2.data.db.entity.openweatherapi.Coord
import com.dreamer.myweather2.data.network.WeatherNetworkDataSource
import com.dreamer.myweather2.data.network.response.FutureWeatherResponse
import com.dreamer.myweather2.data.network.response.OpenCurrentWeatherResponse
import com.dreamer.myweather2.data.provider.LocationProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.threeten.bp.ZonedDateTime
import java.util.*

//import androidx.lifecycle.LiveData
//import com.dreamer.myweather2.data.db.CurrentWeatherDao
//import com.dreamer.myweather2.data.db.FutureWeatherDao
//import com.dreamer.myweather2.data.db.WeatherLocationDao
//import com.dreamer.myweather2.data.db.entity.WeatherLocation
//import com.dreamer.myweather2.data.db.unitlocalized.current.UnitSpecificCurrentWeatherEntry
//import com.dreamer.myweather2.data.db.unitlocalized.future.detail.UnitSpecificDetailFutureWeatherEntry
//import com.dreamer.myweather2.data.db.unitlocalized.future.list.UnitSpecificSimpleFutureWeatherEntry
//import com.dreamer.myweather2.data.network.FORECAST_DAYS_COUNT
//import com.dreamer.myweather2.data.network.WeatherNetworkDataSource
//import com.dreamer.myweather2.data.network.response.CurrentWeatherResponse
//import com.dreamer.myweather2.data.network.response.FutureWeatherResponse
//import com.dreamer.myweather2.data.provider.LocationProvider
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.GlobalScope
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.withContext
//import org.threeten.bp.LocalDate
//import org.threeten.bp.ZonedDateTime
//import java.util.*

class ForecastRepositoryImpl(
        private val currentWeatherDao: CurrentWeatherDao,
//        private val futureWeatherDao: FutureWeatherDao,
        private val weatherLocationDao: WeatherLocationDao,
        private val weatherNetworkDataSource: WeatherNetworkDataSource,
        private val locationProvider: LocationProvider
) : ForecastRepository {


    init {
        weatherNetworkDataSource.apply {
            downloadedOpenCurrentWeather.observeForever { newCurrentWeather ->
                persistFetchedCurrentWeather(newCurrentWeather)
            }
//            downloadedFutureWeather.observeForever { newFutureWeather ->
//                persistFetchedFutureWeather(newFutureWeather)
//            }
        }
    }

    //    override suspend fun getCurrentWeather(metric: Boolean): LiveData<out OpenCurrentWeatherResponse> {
    override suspend fun getCurrentWeather(metric: Boolean): LiveData<OpenCurrentWeatherResponse> {
        Log.e(this.toString(), "fromListLisr3: $this")
        return withContext(Dispatchers.IO) {
            initWeatherData()
            return@withContext if (metric) currentWeatherDao.getWeatherMetric()

            else currentWeatherDao.getWeatherImperial()
        }

    }


    //    override suspend fun getFutureWeatherList(
//            startDate: LocalDate,
//            metric: Boolean
//    ): LiveData<out List<UnitSpecificSimpleFutureWeatherEntry>> {
//        return withContext(Dispatchers.IO) {
//            initWeatherData()
//            return@withContext if (metric) futureWeatherDao.getSimpleWeatherForecastsMetric(startDate)
//            else futureWeatherDao.getSimpleWeatherForecastsImperial(startDate)
//        }
//    }
//
//    override suspend fun getFutureWeatherByDate(
//            date: LocalDate,
//            metric: Boolean
//    ): LiveData<out UnitSpecificDetailFutureWeatherEntry> {
//        return withContext(Dispatchers.IO) {
//            initWeatherData()
//            return@withContext if (metric) futureWeatherDao.getDetailedWeatherByDateMetric(date)
//            else futureWeatherDao.getDetailedWeatherByDateImperial(date)
//        }
//    }
//
    override suspend fun getWeatherLocation(): LiveData<Coord> {
        return withContext(Dispatchers.IO) {
            return@withContext weatherLocationDao.getLocation()
        }
    }

    private fun persistFetchedCurrentWeather(fetchedWeatherOpen: OpenCurrentWeatherResponse) {
        GlobalScope.launch(Dispatchers.IO) {
            //            currentWeatherDao.upsert(fetchedWeatherOpen.weather)
            currentWeatherDao.upsert(fetchedWeatherOpen)
            Log.e(this.toString(), "fromListLisr1: ${fetchedWeatherOpen}")
            weatherLocationDao.upsert(fetchedWeatherOpen.location)
            Log.e(this.toString(), "fromListLisr2: ${fetchedWeatherOpen.location}")
        }
    }

    //
    private fun persistFetchedFutureWeather(fetchedWeather: FutureWeatherResponse) {
//
//        fun deleteOldForecastData() {
//            val today = LocalDate.now()
//            futureWeatherDao.deleteOldEntries(today)
//        }
//
        GlobalScope.launch(Dispatchers.IO) {
            //            deleteOldForecastData()
            val futureWeatherList = fetchedWeather.futureWeatherEntries.entries
//            futureWeatherDao.insert(futureWeatherList)
//            weatherLocationDao.upsert(fetchedWeather.location)
        }
    }

    private suspend fun initWeatherData() {
        val lastWeatherLocation = weatherLocationDao.getLocationNonLive()

        if (lastWeatherLocation == null
                || locationProvider.hasLocationChanged(lastWeatherLocation)) {
            fetchCurrentWeather()
//            fetchFutureWeather()
            return
        }

//        if (isFetchCurrentNeeded(lastWeatherLocation.zonedDateTime))
//            fetchCurrentWeather()

//        if (isFetchFutureNeeded())
//            fetchFutureWeather()
    }

    private suspend fun fetchCurrentWeather() {
        weatherNetworkDataSource.fetchCurrentWeather(
                locationProvider.getPreferredLocationString(),
                Locale.getDefault().language,
                unitsCode = "metric"

        )
    }

//    private suspend fun fetchFutureWeather() {
//        weatherNetworkDataSource.fetchFutureWeather(
//                locationProvider.getPreferredLocationString(),
//                Locale.getDefault().language
//        )
//    }

    private fun isFetchCurrentNeeded(lastFetchTime: ZonedDateTime): Boolean {
        val thirtyMinutesAgo = ZonedDateTime.now().minusMinutes(30)
        return lastFetchTime.isBefore(thirtyMinutesAgo)
    }

//    private fun isFetchFutureNeeded(): Boolean {
//        val today = LocalDate.now()
//        val futureWeatherCount = futureWeatherDao.countFutureWeather(today)
//        return futureWeatherCount < FORECAST_DAYS_COUNT
//    }
}