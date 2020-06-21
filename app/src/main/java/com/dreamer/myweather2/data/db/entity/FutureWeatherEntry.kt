package com.dreamer.myweather2.data.db.entity

//const val FUTURENT_WEATHER_ID = 0
//
//@Entity(tableName = "future_weather"
//        //,
//        //indices = [Index(value = ["dtTxt"], unique = true
//        //)
//        //]
//)
//@TypeConverters(
//        X_Converter::class
////                CoordConverter::class,
//////        SysConverter::class,
////                MainConverter::class
//)
//data class FutureWeatherEntry(
//
////        @PrimaryKey(autoGenerate = true)
////        val id: Int? = null,
////        val dtTxt: Int,
//////        @Embedded
//////        val day: FutureRequest
////
////        var cod: String, // 200
////        var message: Double, // 0.0032
////        var cnt: Int, // 36
//        @SerializedName("list")
//        var list: List<X_future>
////        @SerializedName("city")
////        @Embedded(prefix = "city_")
////        var city: City
//) {
//        @PrimaryKey(autoGenerate = false)
//        var id: Int = FUTURENT_WEATHER_ID
//}
//
//class X_Converter {
//        @TypeConverter
//        fun fromString(value: String): List<X_future> {
//                Log.e(this@X_Converter.toString(), "FutureList1: ${value.last()}")
//            return Gson().fromJson(value, object : TypeToken<List<X_future>>() {}.type)
//        }
//
//        @TypeConverter
//        fun fromJson(value: List<X_future>): String {
//                Log.e(this@X_Converter.toString(), "futureList2: ${value.last()}")
//                return Gson().toJson(value)
//        }
//
//}