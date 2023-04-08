package com.dreamer.myweather2.data.db.unitlocalized.future.list

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import com.dreamer.myweather2.data.db.entity.furute.Weather
import org.threeten.bp.LocalDateTime


data class MetricSimpleFutureWeatherEntry(
    @ColumnInfo(name = "dtTxt")
    override val date: LocalDateTime,
//        @ColumnInfo(name = "city_coord_lat")
    @ColumnInfo(name = "main_temp")
    override val avgTemperature: Double,
    @ColumnInfo(name = "weather")
    override val conditionText: List<Weather>,
    @ColumnInfo(name = "clouds_all")
    override val conditionIconUrl: Double,
//        @ColumnInfo(name = "name")
//        override val name: String
) : UnitSpecificSimpleFutureWeatherEntry {
    constructor(parcel: Parcel) : this(
        TODO("date"),
        parcel.readDouble(),
        TODO("conditionText"),
        parcel.readDouble()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        writeToParcel(parcel, flags)
        parcel.writeDouble(avgTemperature)
        parcel.writeDouble(conditionIconUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MetricSimpleFutureWeatherEntry> {
        override fun createFromParcel(parcel: Parcel): MetricSimpleFutureWeatherEntry {
            return MetricSimpleFutureWeatherEntry(parcel)
        }

        override fun newArray(size: Int): Array<MetricSimpleFutureWeatherEntry?> {
            return arrayOfNulls(size)
        }
    }

}
