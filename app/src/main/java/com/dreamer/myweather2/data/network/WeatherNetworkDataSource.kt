package com.dreamer.myweather2.data.network

import androidx.lifecycle.LiveData
import com.dreamer.myweather2.data.network.response.FutureWeatherResponse
import com.dreamer.myweather2.data.network.response.OpenCurrentWeatherResponse


interface WeatherNetworkDataSource {
    val downloadedOpenCurrentWeather: LiveData<OpenCurrentWeatherResponse>
    val downloadedFutureWeather: LiveData<FutureWeatherResponse>

    suspend fun fetchCurrentWeather(
            location: String,
            languageCode: String,
            unitsCode: String
    )

    suspend fun fetchCurrentWeather1(
            lat: String,
            lon: String,
            languageCode: String,
            unitsCode: String
    )

    suspend fun fetchFutureWeather(
            location: String,
            country: String,
            languageCode: String,
            unitsCode: String
    )
}