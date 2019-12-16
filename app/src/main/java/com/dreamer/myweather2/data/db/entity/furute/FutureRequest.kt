package com.dreamer.myweather2.data.db.entity.furute


data class FutureRequest(
        var cod: String, // 200
        var message: Double, // 0.0032
        var cnt: Int, // 36
        var list: List<X>,
        var city: City
)