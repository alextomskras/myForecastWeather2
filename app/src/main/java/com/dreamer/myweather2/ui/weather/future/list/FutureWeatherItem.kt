package com.dreamer.myweather2.ui.weather.future.list


import android.util.Log
import com.dreamer.myweather2.R
import com.dreamer.myweather2.data.db.unitlocalized.future.list.MetricSimpleFutureWeatherEntry
import com.dreamer.myweather2.data.db.unitlocalized.future.list.UnitSpecificSimpleFutureWeatherEntry
import com.squareup.picasso.Picasso
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_future_weather.*
import org.threeten.bp.format.DateTimeFormatter


class FutureWeatherItem(
        val weatherEntry: UnitSpecificSimpleFutureWeatherEntry
) : Item() {
    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.apply {
            textView_condition.text = weatherEntry.conditionText.toString()
            Log.e("fun bind", "from with1 $weatherEntry")
//            textView_condition.text = "weatherEntry.conditionText"
            updateDate()
            updateTemperature()
            updateConditionImage()
        }
    }

    override fun getLayout() = R.layout.item_future_weather

    private fun ViewHolder.updateDate() {
//        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
//        val dtFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
        val dtFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        textView_date.text = weatherEntry.date.format(dtFormatter)
//        textView_date.text = "weatherEntry"
    }

    private fun ViewHolder.updateTemperature() {
        val unitAbbreviation = if (weatherEntry is MetricSimpleFutureWeatherEntry) "°C"
        else "°F"
        textView_temperature.text = "${weatherEntry.avgTemperature}$unitAbbreviation"
//        textView_temperature.text = "14.2$unitAbbreviation"
    }

    private fun ViewHolder.updateConditionImage() {
        Log.e(this.toString(), "from with2 error code: picturesUrl")
        try {
            Picasso.get()
//                        .load("${picturesUrl}")
                    .load("https:" + "//assets.weatherstack.com/images/wsymbols01_png_64/wsymbol_0008_clear_sky_night.png")
//            ("http://openweathermap.org/img/wn/" + "$picturesUrl" + "@2x" + ".png")
//                        .load("https://assets.weatherstack.com/images/wsymbols01_png_64/wsymbol_0008_clear_sky_night.png")
                    .fit()
                    .into(imageView_condition_icon)
        } catch (e: Exception) {
            e.printStackTrace()
        }
//        GlideApp.with(this.containerView)
////                .load("http:" + weatherEntry.conditionIconUrl)
////                .load(http://openweathermap.org/img/wn/" + "$picturesUrl" + "@2x" + ".png")
//                .load("https:" + "//assets.weatherstack.com/images/wsymbols01_png_64/wsymbol_0008_clear_sky_night.png")
//                .into(imageView_condition_icon)
    }
}