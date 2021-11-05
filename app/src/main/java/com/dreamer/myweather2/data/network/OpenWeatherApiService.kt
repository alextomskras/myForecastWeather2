package com.dreamer.myweather2.data.network

import com.dreamer.myweather2.data.network.response.FutureWeatherResponse
import com.dreamer.myweather2.data.network.response.OpenCurrentWeatherResponse
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
//https://api.openweathermap.org/data/2.5/weather?lat=37.4054054054054&lon=12.07727056202968&lang=en&units=metric&appid=f9d142fda1995a149d1b35f11bc9a928

interface OpenWeatherApiService {

    @GET("weather")
    fun getCurrentWeather(
            @Query("q") location: String,
            @Query("lang") languageCode: String = "en",
//            unitsCode: String
            @Query("units") unitsCode: String = "metric"

    ): Deferred<OpenCurrentWeatherResponse>

    @GET("weather")
    fun getCurrentWeather1(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("lang") languageCode: String = "en",
//            unitsCode: String
        @Query("units") unitsCode: String = "metric"

    )
            : Deferred<OpenCurrentWeatherResponse>


    // https://api.apixu.com/v1/forecast.json?key=89e8bd89085b41b7a4b142029180210&q=Los%20Angeles&days=1
    // https://api.openweathermap.org/data/2.5/forecast?q=Moscow,ru&appid=f9d142fda1995a149d1b35f11bc9a928&units=metric

    @GET("forecast")
    fun getFutureWeather(
            @Query("q") location: String,
            @Query("query") country: String,
            @Query("days") days: Int,
            @Query("lang") languageCode: String = "en",
            @Query("units") unitsCode: String = "metric"

    ): Deferred<FutureWeatherResponse>

    companion object {
        operator fun invoke(
                connectivityInterceptor: ConnectivityInterceptor
        ): OpenWeatherApiService {
            val requestInterceptor = Interceptor { chain ->

                val url = chain.request()
                        .url
                        .newBuilder()
//                        .addQueryParameter("lat", "$location")
//                        .addQueryParameter("lon", "123.332133")
                        .addQueryParameter("appid", APP_KEY)
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
                    .addInterceptor(connectivityInterceptor)
                    .addInterceptor(requestInterceptor)
                    .addInterceptor(logging)

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