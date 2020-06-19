package com.dreamer.myweather2.data.network.response


import com.dreamer.myweather2.data.db.entity.furute.X_future
import com.google.gson.annotations.SerializedName

data class ForecastDaysContainer(
        @SerializedName("list")
        val entries: List<X_future>
)