package com.resocoder.myweather2.data.db.entity.forecast


import com.google.gson.annotations.SerializedName

data class Astro(
        @SerializedName("moon_illumination")
        val moonIllumination: Int = 0, // 39
        @SerializedName("moon_phase")
        val moonPhase: String = "", // Waxing Crescent
        val moonrise: String = "", // 01:34 PM
        val moonset: String = "", // 11:54 PM
        val sunrise: String = "", // 07:15 AM
        val sunset: String = "" // 05:59 PM
)