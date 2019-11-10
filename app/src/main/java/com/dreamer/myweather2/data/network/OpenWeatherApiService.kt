package com.dreamer.myweather2.data.network

import com.dreamer.myweather2.data.network.response.CurrentWeatherResponse
import com.dreamer.myweather2.data.network.response.FutureWeatherResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//appid=f9d142fda1995a149d1b35f11bc9a928
//New_key access_key=3e735f3d35d2f20f7604151dd0742757

const val APP_KEY = "f9d142fda1995a149d1b35f11bc9a928"
//Old
//http://api.apixu.com/v1/current.json?key=89e8bd89085b41b7a4b142029180210&q=London&lang=en
//New
//http://api.weatherstack.com/forecast?access_key=3e735f3d35d2f20f7604151dd0742757&query=Moscow
//
//https://api.openweathermap.org/data/2.5/weather?q=Moscow&appid=f9d142fda1995a149d1b35f11bc9a928

interface OpenWeatherApiService {

    @GET("current")
    fun getCurrentWeather(
            @Query("q") location: String,
            @Query("lang") languageCode: String = "en"
    ): Deferred<CurrentWeatherResponse>


    // https://api.apixu.com/v1/forecast.json?key=89e8bd89085b41b7a4b142029180210&q=Los%20Angeles&days=1
    @GET("forecast")
    fun getFutureWeather(
            @Query("query") location: String,
            @Query("days") days: Int,
            @Query("lang") languageCode: String = "en"
    ): Deferred<FutureWeatherResponse>

    companion object {
        operator fun invoke(
                connectivityInterceptor: ConnectivityInterceptor
        ): OpenWeatherApiService {
            val requestInterceptor = Interceptor { chain ->

                val url = chain.request()
                        .url
                        .newBuilder()
                        .addQueryParameter("access_key", APP_KEY)
                        .build()
                val request = chain.request()
                        .newBuilder()
                        .url(url)
                        .build()

                return@Interceptor chain.proceed(request)
            }

            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(requestInterceptor)
                    .addInterceptor(logging)
                    .addInterceptor(connectivityInterceptor)
                    .build()

            return Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("https://api.openweathermap.org/data/2.5/")
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(OpenWeatherApiService::class.java)
        }
    }
}