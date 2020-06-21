package com.dreamer.myweather2

import android.app.Application
import android.content.Context
import android.preference.PreferenceManager
import com.dreamer.myweather2.data.db.ForecastDatabase
import com.dreamer.myweather2.data.network.*
import com.dreamer.myweather2.data.provider.LocationProvider
import com.dreamer.myweather2.data.provider.LocationProviderImpl
import com.dreamer.myweather2.data.provider.UnitProvider
import com.dreamer.myweather2.data.provider.UnitProviderImpl
import com.dreamer.myweather2.data.repository.ForecastRepository
import com.dreamer.myweather2.data.repository.ForecastRepositoryImpl
import com.dreamer.myweather2.ui.weather.current.CurrentWeatherViewModelFactory
import com.dreamer.myweather2.ui.weather.future.detail.FutureDetailWeatherViewModelFactory
import com.dreamer.myweather2.ui.weather.future.list.FutureListWeatherViewModelFactory
import com.google.android.gms.location.LocationServices
import com.jakewharton.threetenabp.AndroidThreeTen
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.*
import org.threeten.bp.LocalDateTime


class ForecastApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@ForecastApplication))

        bind() from singleton { ForecastDatabase(instance()) }
        bind() from singleton { instance<ForecastDatabase>().currentWeatherDao() }
        bind() from singleton { instance<ForecastDatabase>().futureWeatherDao() }
        bind() from singleton { instance<ForecastDatabase>().weatherLocationDao() }
        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton { ApixuWeatherApiService(instance()) }
        bind() from singleton { OpenWeatherApiService(instance()) }
        bind<WeatherNetworkDataSource>() with singleton { WeatherNetworkDataSourceImpl(instance()) }
        bind() from provider { LocationServices.getFusedLocationProviderClient(instance<Context>()) }
        bind<LocationProvider>() with singleton { LocationProviderImpl(instance(), instance()) }
        bind<ForecastRepository>() with singleton { ForecastRepositoryImpl(instance(), instance(), instance(), instance(), instance()) }
        bind<UnitProvider>() with singleton { UnitProviderImpl(instance()) }
        bind() from provider { CurrentWeatherViewModelFactory(instance(), instance()) }
        bind() from provider { FutureListWeatherViewModelFactory(instance(), instance()) }
        bind() from factory { detailDate: LocalDateTime -> FutureDetailWeatherViewModelFactory(detailDate, instance(), instance()) }

    }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false)
    }
}