package com.resocoder.myweather2.data.db.entity.forecast


import com.google.gson.annotations.SerializedName

data class X20191103(
        val astro: Astro = Astro(),
        val avgtemp: Int = 0, // 24
        val date: String = "", // 2019-11-03
        @SerializedName("date_epoch")
        val dateEpoch: Int = 0, // 1572739200
        val maxtemp: Int = 0, // 27
        val mintemp: Int = 0, // 22
        val sunhour: Double = 0.0, // 8.7
        val totalsnow: Int = 0, // 0
        @SerializedName("uv_index")
        val uvIndex: Int = 0 // 6
)