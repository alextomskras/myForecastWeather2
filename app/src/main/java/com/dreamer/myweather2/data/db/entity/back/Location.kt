package com.dreamer.myweather2.data.db.entity.back


import com.google.gson.annotations.SerializedName

data class Location(
        val country: String, // United States of America
        val lat: String, // 34.052
        val localtime: String, // 2019-11-01 13:29
        @SerializedName("localtime_epoch")
        val localtimeEpoch: Int, // 1572614940
        val lon: String, // -118.243
        val name: String, // Los Angeles
        val region: String, // California
        @SerializedName("timezone_id")
        val timezoneId: String, // America/Los_Angeles
        @SerializedName("utc_offset")
        val utcOffset: String // -7.0
)