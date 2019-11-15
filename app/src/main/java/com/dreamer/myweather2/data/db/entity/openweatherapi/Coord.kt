package com.dreamer.myweather2.data.db.entity.openweatherapi

import androidx.room.Entity
import androidx.room.PrimaryKey

const val COORD_CURRENT_WEATHER_ID = 0

@Entity(tableName = "coord_entry")
data class Coord(
        val lat: Double, // 55.75
        val lon: Double // 37.62

) {

    @PrimaryKey(autoGenerate = false)
    var id: Int = COORD_CURRENT_WEATHER_ID

//    val zonedDateTime: ZonedDateTime
//        get() {
//            val instant = Instant.ofEpochSecond(localtimeEpoch)
//            val zoneId = ZoneId.of(tzId)
//            return ZonedDateTime.ofInstant(instant, zoneId)
//        }
}