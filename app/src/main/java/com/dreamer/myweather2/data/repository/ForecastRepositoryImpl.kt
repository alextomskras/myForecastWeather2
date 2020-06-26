package com.dreamer.myweather2.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.dreamer.myweather2.data.db.CurrentWeatherDao
import com.dreamer.myweather2.data.db.FutureWeatherDao
import com.dreamer.myweather2.data.db.WeatherLocationDao
import com.dreamer.myweather2.data.db.entity.openweatherapi.Coord
import com.dreamer.myweather2.data.db.unitlocalized.future.detail.UnitSpecificDetailFutureWeatherEntry
import com.dreamer.myweather2.data.db.unitlocalized.future.list.UnitSpecificSimpleFutureWeatherEntry
import com.dreamer.myweather2.data.network.FORECAST_DAYS_COUNT
import com.dreamer.myweather2.data.network.WeatherNetworkDataSource
import com.dreamer.myweather2.data.network.response.FutureWeatherResponse
import com.dreamer.myweather2.data.network.response.OpenCurrentWeatherResponse
import com.dreamer.myweather2.data.provider.LocationProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZoneOffset
import org.threeten.bp.ZonedDateTime
import java.util.*


class ForecastRepositoryImpl(
        private val currentWeatherDao: CurrentWeatherDao,
        private val futureWeatherDao: FutureWeatherDao,
        private val weatherLocationDao: WeatherLocationDao,
        private val weatherNetworkDataSource: WeatherNetworkDataSource,
        private val locationProvider: LocationProvider
) : ForecastRepository {


    init {
        weatherNetworkDataSource.apply {
            downloadedOpenCurrentWeather.observeForever { newCurrentWeather ->
                persistFetchedCurrentWeather(newCurrentWeather)
            }
            downloadedFutureWeather.observeForever { newFutureWeather ->
                persistFetchedFutureWeather(newFutureWeather)
            }
        }
    }

    //    override suspend fun getCurrentWeather(metric: Boolean): LiveData<out OpenCurrentWeatherResponse> {
    override suspend fun getCurrentWeather(metric: Boolean): LiveData<OpenCurrentWeatherResponse> {
        Log.e(this.toString(), "fromgetCurrentWeather: $this")
        return withContext(Dispatchers.IO) {
            initWeatherData()
            return@withContext if (metric) currentWeatherDao.getWeatherMetric()

            else currentWeatherDao.getWeatherImperial()
        }

    }


    override suspend fun getFutureWeatherList(startDate: LocalDateTime, metric: Boolean):
//            LiveData<out List<UnitSpecificSimpleFutureWeatherEntry>>
            LiveData<out List<UnitSpecificSimpleFutureWeatherEntry>> {
        Log.e(this.toString(), "from_getFutureWeat: $this")
        return withContext(Dispatchers.IO) {
            Log.e(this.toString(), "from_getFutureWeatherList::: $this")
            initWeatherData()
            return@withContext if (metric) futureWeatherDao.getSimpleWeatherForecastsMetric(startDate)
            else futureWeatherDao.getSimpleWeatherForecastsImperial(startDate)
        }
    }

    override suspend fun getFutureWeatherByDate(
            date: LocalDateTime,

            metric: Boolean
    ): LiveData<out UnitSpecificDetailFutureWeatherEntry> {
        val epocheMill = date.toEpochSecond(ZoneOffset.UTC).toInt()
//        val epocheMill = 12341223423
        Log.e(this.toString(), "from_getFutureWeatherByDate: $this" + "epocheMill: $epocheMill")
        return withContext(Dispatchers.IO) {
            initWeatherData()
            return@withContext if (metric) futureWeatherDao.getDetailedWeatherByDateMetric(epocheMill = epocheMill)
            else futureWeatherDao.getDetailedWeatherByDateImperial(date)
        }
    }

    override suspend fun getWeatherLocation(): LiveData<Coord> {
        Log.e(this.toString(), "from_getWeatherLocation: $this")
        return withContext(Dispatchers.IO) {
            return@withContext weatherLocationDao.getLocation()
        }
    }

    private fun persistFetchedCurrentWeather(fetchedWeatherOpen: OpenCurrentWeatherResponse) {
        GlobalScope.launch(Dispatchers.IO) {
            //            currentWeatherDao.upsert(fetchedWeatherOpen.futureWeather)
            currentWeatherDao.upsert(fetchedWeatherOpen)
            Log.e(this.toString(), "from_currentWeatherDao.upsert: ${fetchedWeatherOpen}")
            weatherLocationDao.upsert(fetchedWeatherOpen.location)
            Log.e(this.toString(), "from_weatherLocationDao.upsert: ${fetchedWeatherOpen.location}")
        }
    }

    //
    private fun persistFetchedFutureWeather(fetchedWeather: FutureWeatherResponse) {

        fun deleteOldForecastData() {
            val today = LocalDateTime.now()
            futureWeatherDao.deleteOldEntries(today)
        }

        GlobalScope.launch(Dispatchers.IO) {
            deleteOldForecastData()
//            val futureWeatherList = fetchedWeather.futureWeatherEntries
            val futureWeatherList = fetchedWeather.futureWeatherEntries
            Log.e("FutureWeather::", "from_futureWeatherList.insert:: ${futureWeatherList}")
//            val futureWeatherList = fetchedWeather.futureWeatherEntries.entries
            futureWeatherDao.insert(futureWeatherList)
            Log.e("FutureWeather::", "from_FutureWeatherDao.insert:: ${futureWeatherList}")
//            weatherLocationDao.upsert(fetchedWeather.location)
        }
    }

    private suspend fun initWeatherData() {
        val lastWeatherLocation = weatherLocationDao.getLocationNonLive()
        val zonedDateTime = ZonedDateTime.now()

        if (lastWeatherLocation == null
                || locationProvider.hasLocationChanged(lastWeatherLocation)) {
            fetchCurrentWeather()
            fetchFutureWeather()
            return
        }
//lastWeatherLocation.zonedDateTime

        if (isFetchCurrentNeeded(zonedDateTime))
            fetchCurrentWeather()

        if (isFetchFutureNeeded())
            fetchFutureWeather()
    }

    private suspend fun fetchCurrentWeather() {
        weatherNetworkDataSource.fetchCurrentWeather(
                locationProvider.getPreferredLocationString(),
                Locale.getDefault().language,
                unitsCode = "metric"

        )
    }

    private suspend fun fetchFutureWeather() {
        weatherNetworkDataSource.fetchFutureWeather(
                locationProvider.getPreferredLocationString(),
                Locale.getDefault().language,
                unitsCode = "metric",
                languageCode = "en"

        )
    }

    private fun isFetchCurrentNeeded(lastFetchTime: ZonedDateTime): Boolean {
        val thirtyMinutesAgo = ZonedDateTime.now().minusMinutes(30)
        return lastFetchTime.isBefore(thirtyMinutesAgo)
    }

    private fun isFetchFutureNeeded(): Boolean {
        val today = LocalDateTime.now()
        val futureWeatherCount = futureWeatherDao.countFutureWeather(today)
        return futureWeatherCount < FORECAST_DAYS_COUNT
    }
}