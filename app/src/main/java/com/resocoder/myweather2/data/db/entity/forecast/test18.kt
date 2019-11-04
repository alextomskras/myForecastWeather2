package com.resocoder.myweather2.data.db.entity.forecast


data class test18(
        val current: Current = Current(),
        val forecast: Forecast = Forecast(),
        val location: Location = Location(),
        val request: Request = Request()
)