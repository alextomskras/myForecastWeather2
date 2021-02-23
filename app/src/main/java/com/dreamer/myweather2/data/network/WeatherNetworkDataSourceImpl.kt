package com.dreamer.myweather2.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dreamer.myweather2.data.network.response.FutureWeatherResponse
import com.dreamer.myweather2.data.network.response.OpenCurrentWeatherResponse
import com.dreamer.myweather2.internal.NoConnectivityException

const val FORECAST_DAYS_COUNT = 5

class WeatherNetworkDataSourceImpl(
        private val openWeatherApiService: OpenWeatherApiService
) : WeatherNetworkDataSource {

    private val _downloadedCurrentWeather = MutableLiveData<OpenCurrentWeatherResponse>()
    override val downloadedOpenCurrentWeather: LiveData<OpenCurrentWeatherResponse>
        get() = _downloadedCurrentWeather

    override suspend fun fetchCurrentWeather(location: String, languageCode: String, unitsCode: String) {
        try {
            val fetchedCurrentWeather = openWeatherApiService
                    .getCurrentWeather(location, languageCode, unitsCode)
                    .await()
            _downloadedCurrentWeather.postValue(fetchedCurrentWeather)
        } catch (e: NoConnectivityException) {
            Log.e("Connectivity", "No internet connection.", e)
        }
    }

    override suspend fun fetchCurrentWeather1(lat: String, lon: String, languageCode: String, unitsCode: String) {
        try {
            val fetchedCurrentWeather = openWeatherApiService
                    .getCurrentWeather1(lat, lon, languageCode, unitsCode)
                    .await()
            _downloadedCurrentWeather.postValue(fetchedCurrentWeather)
        } catch (e: NoConnectivityException) {
            Log.e("Connectivity", "No internet connection.", e)
        }
    }

    private val _downloadedFutureWeather = MutableLiveData<FutureWeatherResponse>()
    override val downloadedFutureWeather: LiveData<FutureWeatherResponse>
        get() = _downloadedFutureWeather

    override suspend fun fetchFutureWeather(
            location: String,
            country: String,
            languageCode: String,
            unitsCode: String
    ) {
        try {
            val fetchedFutureWeather = openWeatherApiService
                    .getFutureWeather(location, country, FORECAST_DAYS_COUNT, languageCode, unitsCode)
                    .await()
            _downloadedFutureWeather.postValue(fetchedFutureWeather)
        } catch (e: NoConnectivityException) {
            Log.e("Connectivity", "No internet connection.", e)
        }
    }
}