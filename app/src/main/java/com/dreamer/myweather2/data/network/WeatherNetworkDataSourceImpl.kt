package com.dreamer.myweather2.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dreamer.myweather2.data.network.response.CurrentWeatherResponse
import com.dreamer.myweather2.data.network.response.FutureWeatherResponse
import com.dreamer.myweather2.internal.NoConnectivityException

const val FORECAST_DAYS_COUNT = 5

class WeatherNetworkDataSourceImpl(
        private val openWeatherApiService: OpenWeatherApiService
) : WeatherNetworkDataSource {

    private val _downloadedCurrentWeather = MutableLiveData<CurrentWeatherResponse>()
    override val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>
        get() = _downloadedCurrentWeather

    override suspend fun fetchCurrentWeather(location: String, languageCode: String) {
        try {
            val fetchedCurrentWeather = openWeatherApiService
                    .getCurrentWeather(location, languageCode)
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
            languageCode: String
    ) {
        try {
            val fetchedFutureWeather = openWeatherApiService
                    .getFutureWeather(location, FORECAST_DAYS_COUNT, languageCode)
                    .await()
            _downloadedFutureWeather.postValue(fetchedFutureWeather)
        } catch (e: NoConnectivityException) {
            Log.e("Connectivity", "No internet connection.", e)
        }
    }
}