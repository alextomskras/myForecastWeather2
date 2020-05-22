package com.dreamer.myweather2.data.db.entity.furute

import com.google.gson.annotations.SerializedName


data class Wind(
        @SerializedName("speed")
        var speed: Double, // 3.57
        @SerializedName("deg")
        var deg: Double // 255.503
)