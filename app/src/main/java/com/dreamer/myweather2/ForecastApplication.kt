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

        bind() from this.singleton { return@singleton ForecastDatabase(context = this.instance()) }
        bind() from this.singleton { this.instance<ForecastDatabase>().currentWeatherDao() }
        bind() from this.singleton { this.instance<ForecastDatabase>().futureWeatherDao() }
        bind() from this.singleton { this.instance<ForecastDatabase>().weatherLocationDao() }
        this.bind<ConnectivityInterceptor>() with this.singleton { ConnectivityInterceptorImpl(this.instance()) }
        bind() from this.singleton { ApixuWeatherApiService(this.instance()) }
        bind() from this.singleton { OpenWeatherApiService(this.instance()) }
        this.bind<WeatherNetworkDataSource>() with this.singleton { WeatherNetworkDataSourceImpl(this.instance()) }
        bind() from this.provider { LocationServices.getFusedLocationProviderClient(this.instance<Context>()) }
        this.bind<LocationProvider>() with this.singleton { LocationProviderImpl(this.instance(), this.instance()) }
        this.bind<ForecastRepository>() with this.singleton { ForecastRepositoryImpl(this.instance(), this.instance(), this.instance(), this.instance(), this.instance()) }
        this.bind<UnitProvider>() with this.singleton { UnitProviderImpl(this.instance()) }
        bind() from this.provider { CurrentWeatherViewModelFactory(this.instance(), this.instance()) }
        bind() from this.provider { FutureListWeatherViewModelFactory(this.instance(), this.instance()) }
        bind() from this.factory { detailDate: LocalDateTime -> FutureDetailWeatherViewModelFactory(detailDate, this.instance(), this.instance()) }

    }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false)
    }
}