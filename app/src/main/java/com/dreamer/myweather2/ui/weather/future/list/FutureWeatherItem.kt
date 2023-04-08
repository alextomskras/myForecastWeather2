package com.dreamer.myweather2.ui.weather.future.list


//import com.xwray.groupie.kotlinandroidextensions.Item
//import com.xwray.groupie.kotlinandroidextensions.ViewHolder
//import kotlinx.android.synthetic.main.item_future_weather.*
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.dreamer.myweather2.R
import com.dreamer.myweather2.data.db.unitlocalized.future.list.MetricSimpleFutureWeatherEntry
import com.dreamer.myweather2.data.db.unitlocalized.future.list.UnitSpecificSimpleFutureWeatherEntry
import org.threeten.bp.format.DateTimeFormatter


class FutureWeatherItem(
    val weatherEntry: UnitSpecificSimpleFutureWeatherEntry,
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readParcelable(UnitSpecificSimpleFutureWeatherEntry::class.java.classLoader)!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(weatherEntry, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    fun getLayout(): Int = R.layout.item_future_weather

    fun bind(view: View, position: Int) {
        val context = view.context
        val textViewCondition = view.findViewById<TextView>(R.id.textView_condition)
        val textViewDate = view.findViewById<TextView>(R.id.textView_date)
        val textViewTemperature = view.findViewById<TextView>(R.id.textView_temperature)
        val imageViewConditionIcon =
            view.findViewById<ImageView>(R.id.imageView_condition_icon_future_list)

        val arr = arrayOf(weatherEntry.conditionText)
        textViewCondition.text = weatherEntry.conditionText.last().description.toString()
        updateDate(textViewDate)
        updateTemperature(textViewTemperature)
        updateConditionImage(imageViewConditionIcon)
    }

    private fun updateDate(textViewDate: TextView) {
        val dtFormatter = DateTimeFormatter.ofPattern("dd-MM HH:mm")
        textViewDate.text = weatherEntry.date.format(dtFormatter)
    }

    private fun updateTemperature(textViewTemperature: TextView) {
        val unitAbbreviation = if (weatherEntry is MetricSimpleFutureWeatherEntry) "°C"
        else "°F"
        textViewTemperature.text = "${weatherEntry.avgTemperature.toInt()}$unitAbbreviation"
    }

    private fun updateConditionImage(imageViewConditionIcon: ImageView) {
        val picturesUrl = weatherEntry.conditionText.last().icon.toString()
        val iconUrl = "https://openweathermap.org/img/wn/$picturesUrl@2x.png"
        Glide.with(imageViewConditionIcon.context)
            .load(iconUrl)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(imageViewConditionIcon)
    }

    companion object CREATOR : Parcelable.Creator<FutureWeatherItem> {
        override fun createFromParcel(parcel: Parcel): FutureWeatherItem {
            return FutureWeatherItem(parcel)
        }

        override fun newArray(size: Int): Array<FutureWeatherItem?> {
            return arrayOfNulls(size)
        }
    }
}


//class FutureWeatherItem(
//    val weatherEntry: UnitSpecificSimpleFutureWeatherEntry
//) : ClipData.Item(), Parcelable {
//
////    constructor(parcel: Parcel) : this(TODO("weatherEntry")) {
////    }
//
//    fun getLayout(): Int = R.layout.item_future_weather
//
//    fun bind(viewHolder: RecyclerView.ViewHolder, position: Int) {
//        val context = viewHolder.itemView.context
////        val context = viewHolder.itemView.context as AppCompatActivity
//        val itemView = viewHolder.itemView
//        val textViewCondition = itemView.findViewById<TextView>(R.id.textView_condition)
//        val textViewDate = itemView.findViewById<TextView>(R.id.textView_date)
//        val textViewTemperature = itemView.findViewById<TextView>(R.id.textView_temperature)
//        val imageViewConditionIcon = itemView.findViewById<ImageView>(R.id.imageView_condition_icon_future_list)
//
//        val arr = arrayOf(weatherEntry.conditionText)
//        textViewCondition.text = weatherEntry.conditionText.last().description.toString()
//        updateDate(textViewDate)
//        updateTemperature(textViewTemperature)
//        updateConditionImage(imageViewConditionIcon)
//    }
//
//    @SuppressLint("SetTextI18n")
//    private fun updateDate(textViewDate: TextView) {
//        val dtFormatter = DateTimeFormatter.ofPattern("dd-MM HH:mm")
//        textViewDate.text = weatherEntry.date.format(dtFormatter)
//    }
//
//    @SuppressLint("SetTextI18n")
//    private fun updateTemperature(textViewTemperature: TextView) {
//        val unitAbbreviation = if (weatherEntry is MetricSimpleFutureWeatherEntry) "°C"
//        else "°F"
//        textViewTemperature.text = "${weatherEntry.avgTemperature.toInt()}$unitAbbreviation"
//    }
//
//    private fun updateConditionImage(imageViewConditionIcon: ImageView) {
//        val picturesUrl = weatherEntry.conditionText.last().icon.toString()
//        val iconUrl = "https://openweathermap.org/img/wn/$picturesUrl@2x.png"
//        Glide.with(imageViewConditionIcon.context)
//            .load(iconUrl)
//            .diskCacheStrategy(DiskCacheStrategy.ALL)
//            .into(imageViewConditionIcon)
//    }
//
//    override fun writeToParcel(parcel: Parcel, flags: Int) {
//
//    }
//
//    override fun describeContents(): Int {
//        return 0
//    }
//
//    companion object CREATOR : Parcelable.Creator<FutureWeatherItem> {
//        override fun createFromParcel(parcel: Parcel): FutureWeatherItem {
//            return FutureWeatherItem(parcel)
//        }
//
//        override fun newArray(size: Int): Array<FutureWeatherItem?> {
//            return arrayOfNulls(size)
//        }
//    }
//}


//class FutureWeatherItem(
//        val weatherEntry: UnitSpecificSimpleFutureWeatherEntry
//) : Item() {
//    override fun bind(viewHolder: ViewHolder, position: Int) {
//        val context = AppCompatActivity()
////        var view = getLayout()
//        viewHolder.apply {
//            val arr = arrayOf(weatherEntry.conditionText)
////            val textView_condition = getLayout().findViewById<TextView>(R.id.textView_condition)
//            textView_condition.text = weatherEntry.conditionText.last().description.toString()
////            textView_condition.text = weatherEntry.conditionText[3].toString()
//            Log.e("fun bind", "from with1 $weatherEntry")
//
//            updateDate()
//            updateTemperature()
//            updateConditionImage()
//
//        }
//    }
//
//    override fun getLayout() = R.layout.item_future_weather
//
//    private fun ViewHolder.updateDate() {
//
////        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
////        val dtFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
//        val dtFormatter = DateTimeFormatter.ofPattern("dd-MM HH:mm")
////        val view = getLayout()
////        val textView_date = view.findViewById<TextView>(R.id.textView_condition)
//        textView_date.text = weatherEntry.date.format(dtFormatter)
////        textView_date.text = "weatherEntry"
//    }
//
//    private fun ViewHolder.updateTemperature() {
//        val unitAbbreviation = if (weatherEntry is MetricSimpleFutureWeatherEntry) "°C"
//        else "°F"
//        textView_temperature.text = "${weatherEntry.avgTemperature.toInt()}$unitAbbreviation"
////        textView_temperature.text = "14.2$unitAbbreviation"
//    }
//
//    private fun ViewHolder.updateConditionImage() {
//        val picturesUrl = weatherEntry.conditionText.last().icon.toString()
//        val iconUrl = "https://openweathermap.org/img/wn/" + "$picturesUrl" + "@2x" + ".png"
//        Log.e(this.toString(), "from picturesUrl error code: $picturesUrl")
//        Log.e(this.toString(), "from iconUrl error code: $iconUrl")
//
//
//        GlideApp.with(this.containerView)
////                .load("http:" + weatherEntry.conditionIconUrl)
//                .load("http://openweathermap.org/img/wn/" + "$picturesUrl" + "@2x" + ".png")
////                .load("https://assets.weatherstack.com/images/wsymbols01_png_64/wsymbol_0008_clear_sky_night.png")
//                .into(imageView_condition_icon_future_list)
//    }
//}