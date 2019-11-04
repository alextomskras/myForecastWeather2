package com.dreamer.myweather2.data.db.entity.forecast


import com.google.gson.annotations.SerializedName

data class Forecast(
        @SerializedName("2019-11-03")
        val x20191103: X20191103 = X20191103()
)