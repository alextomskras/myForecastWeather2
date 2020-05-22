package com.dreamer.myweather2.data.db.entity.furute

import androidx.room.Embedded
import com.google.gson.annotations.SerializedName


data class FutureRequest(


        var cod: String, // 200
        var message: Double, // 0.0032
        var cnt: Int, // 36
        @SerializedName("list")
        var list: List<X_future>,
        @SerializedName("city")
        @Embedded(prefix = "city_")
        var city: City
)



