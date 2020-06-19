package com.dreamer.myweather2.data.db.entity.furute

import androidx.room.Embedded
import com.google.gson.annotations.SerializedName


data class City(
        var id: Int, // 6940463
        @SerializedName("name")
        var name: String, // Altstadt
        @SerializedName("coord")
        @Embedded(prefix = "coord_")
        var coord: Coord,
        var country: String, // none

        var population: Int,
        var timezone: Int,
        var sunrise: Int,
        var sunset: Int
)