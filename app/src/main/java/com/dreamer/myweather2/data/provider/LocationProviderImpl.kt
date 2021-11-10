package com.dreamer.myweather2.data.provider

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.util.Log
import androidx.core.content.ContextCompat
import com.dreamer.myweather2.data.db.entity.openweatherapi.Coord
import com.dreamer.myweather2.internal.LocationPermissionNotGrantedException
import com.dreamer.myweather2.internal.asDeferred
import com.google.android.gms.location.FusedLocationProviderClient
import kotlinx.coroutines.Deferred

const val USE_DEVICE_LOCATION = "USE_DEVICE_LOCATION"
const val CUSTOM_LOCATION = "CUSTOM_LOCATION"

class LocationProviderImpl(
    private val fusedLocationProviderClient: FusedLocationProviderClient,
    context: Context
) : PreferenceProvider(context), LocationProvider {

    private val appContext = context.applicationContext

    override suspend fun hasLocationChanged(lastWeatherLocation: Coord?): Boolean {
        val deviceLocationChanged = try {
            hasDeviceLocationChanged(lastWeatherLocation)
        } catch (e: LocationPermissionNotGrantedException) {
            false
        }

        return deviceLocationChanged || hasCustomLocationChanged(lastWeatherLocation)
    }

    override suspend fun getPreferredLocationString(): String {
        if (isUsingDeviceLocation()) {
            try {
                val deviceLocation = getLastDeviceLocation().await()
                    ?: return "${getCustomLocationName()}"
                //возвращаем данные с гпс датчиков
                val devLocation = "${deviceLocation.latitude}" + "," + "${deviceLocation.longitude}"
//                val numbers: MutableList<Int> = mutableListOf(1, 2, 3)
                val devLocArray: MutableList<String> =
                    mutableListOf("${deviceLocation.latitude}", "${deviceLocation.longitude}")
                Log.e("devLocation", "from_devLocation =: $devLocArray")
//                Log.e("devLocation", "from_devLocation =: $devLocation, $devLocArray")
                return devLocation
//                return "${deviceLocation.latitude},${deviceLocation.longitude}"
//                return "${deviceLocation.latitude}${deviceLocation.longitude}"
//                return "lat=${deviceLocation.latitude}'&'lon=${deviceLocation.longitude}"
            } catch (e: LocationPermissionNotGrantedException) {
                return "${getCustomLocationName()}"
            }
        } else
            return "${getCustomLocationName()}"
    }

    override suspend fun getPreferredLocationString1(): MutableList<String> {
        if (isUsingDeviceLocation()) {
            try {
                val deviceLocation = getLastDeviceLocation().await()
                    ?: return mutableListOf("${getCustomLocationName()}")
                //возвращаем данные с гпс датчиков
                val devLocation = "${deviceLocation.latitude}" + "&" + "${deviceLocation.longitude}"
//                val numbers: MutableList<Int> = mutableListOf(1, 2, 3)
                val devLocArray: MutableList<String> =
                    mutableListOf("${deviceLocation.latitude}", "${deviceLocation.longitude}")
                Log.e("devLocation", "from_devLocation =: $devLocation, $devLocArray")
                return devLocArray
//                return "${deviceLocation.latitude},${deviceLocation.longitude}"
//                return "lat=${deviceLocation.latitude}'&'lon=${deviceLocation.longitude}"
            } catch (e: LocationPermissionNotGrantedException) {
                return mutableListOf("${getCustomLocationName()}")
            }
        } else
            return mutableListOf("${getCustomLocationName()}")
    }


    private suspend fun hasDeviceLocationChanged(lastWeatherLocation: Coord?): Boolean {
        if (!isUsingDeviceLocation())
            return false

        val deviceLocation = getLastDeviceLocation().await()
            ?: return false

        // Comparing doubles cannot be done with "=="
        val comparisonThreshold = 0.03
        return Math.abs(deviceLocation.latitude - lastWeatherLocation!!.lat) > comparisonThreshold &&
                Math.abs(deviceLocation.longitude - lastWeatherLocation.lon) > comparisonThreshold
    }

    private fun hasCustomLocationChanged(lastWeatherLocation: Coord?): Boolean {
        if (!isUsingDeviceLocation()) {
            val customLocationName = getCustomLocationName()
            return customLocationName != lastWeatherLocation!!.lat.toString()
        }
        return false
    }

     override fun isUsingDeviceLocation(): Boolean {
         return preferences.getBoolean(USE_DEVICE_LOCATION, true)
     }

    private fun getCustomLocationName(): String? {
        return preferences.getString(CUSTOM_LOCATION, null)
    }

    @SuppressLint("MissingPermission")
    private fun getLastDeviceLocation(): Deferred<Location?> {
        return if (hasLocationPermission())
            fusedLocationProviderClient.lastLocation.asDeferred()
        else
            throw LocationPermissionNotGrantedException()
    }

    private fun hasLocationPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            appContext,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }
}