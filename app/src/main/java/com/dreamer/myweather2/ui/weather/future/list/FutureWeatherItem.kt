package com.dreamer.myweather2.ui.weather.future.list


import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.dreamer.myweather2.R
import com.dreamer.myweather2.data.db.unitlocalized.future.list.MetricSimpleFutureWeatherEntry
import com.dreamer.myweather2.data.db.unitlocalized.future.list.UnitSpecificSimpleFutureWeatherEntry
import com.dreamer.myweather2.internal.glide.GlideApp
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_future_weather.*
import org.threeten.bp.format.DateTimeFormatter


class FutureWeatherItem(
    val weatherEntry: UnitSpecificSimpleFutureWeatherEntry,
) : Item() {
    override fun bind(viewHolder: ViewHolder, position: Int) {
        val context = AppCompatActivity()
        viewHolder.apply {
            val arr = arrayOf(weatherEntry.conditionText)
            textView_condition.text = weatherEntry.conditionText.last().description.toString()
//            textView_condition.text = weatherEntry.conditionText[3].toString()
            Log.e("fun bind", "from with1 $weatherEntry")
//            textView_condition.text = "weatherEntry.conditionText"
//            try {
//                Picasso.get()
////                    .isLoggingEnabled
//
////                        .load("${iconUrl}")
//                        .load("https://openweathermap.org/img/wn/01n.png")
////                    .load("http://openweathermap.org/img/wn/" + "$picturesUrl"+ ".png")
////                    .load("http://openweathermap.org/img/wn/" + "01n" + "@2x" + ".png")
////                        .load("https://assets.weatherstack.com/images/wsymbols01_png_64/wsymbol_0008_clear_sky_night.png")
//                        .placeholder(R.drawable.common_google_signin_btn_icon_dark)
//                        .error(R.drawable.ic_weather_sunny)
//                        .fit()
//                        .into(imageView_condition_icon_future)
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//                GlideApp.with(this.containerView)
////                .load("http:" + weatherEntry.conditionIconUrl)
////                .load("http://openweathermap.org/img/wn/" + "$picturesUrl" + "@2x" + ".png")
//                        .asBitmap()
//                        .load("http://assets.weatherstack.com/images/wsymbols01_png_64/wsymbol_0008_clear_sky_night.png")
//                        .placeholder(R.drawable.common_google_signin_btn_icon_dark)
//                        .error(R.drawable.ic_weather_sunny)
//                        .into(imageView_condition_icon_future)
//            }
            updateDate()
            updateTemperature()
            updateConditionImage()

        }
    }

    override fun getLayout() = R.layout.item_future_weather

    private fun ViewHolder.updateDate() {

//        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
//        val dtFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
        val dtFormatter = DateTimeFormatter.ofPattern("dd-MM HH:mm")
        textView_date.text = weatherEntry.date.format(dtFormatter)
//        textView_date.text = "weatherEntry"
    }

    private fun ViewHolder.updateTemperature() {
        val unitAbbreviation = if (weatherEntry is MetricSimpleFutureWeatherEntry) "°C"
        else "°F"
        textView_temperature.text = "${weatherEntry.avgTemperature.toInt()}$unitAbbreviation"
//        textView_temperature.text = "14.2$unitAbbreviation"
    }

    private fun ViewHolder.updateConditionImage() {
        val picturesUrl = weatherEntry.conditionText.last().icon.toString()
        val iconUrl = "https://openweathermap.org/img/wn/" + "$picturesUrl" + "@2x" + ".png"
        Log.e(this.toString(), "from picturesUrl error code: $picturesUrl")
        Log.e(this.toString(), "from iconUrl error code: $iconUrl")
//        try {
//            Picasso.get()
//
////                    .isLoggingEnabled
//
//                        .load(iconUrl)
////                    .load("http://www.weatherbit.io/static/img/icons/r01d.png")
////                    .load("https://goo.gl/32YN2B")
////                    .load("http://openweathermap.org/img/wn/" + "$picturesUrl"+ ".png")
////                    .load("https://openweathermap.org/img/wn/" + "01n" + "@2x" + ".png")
////                        .load("https://assets.weatherstack.com/images/wsymbols01_png_64/wsymbol_0008_clear_sky_night.png")
//                    .placeholder(R.drawable.common_google_signin_btn_icon_dark)
//                    .error(R.drawable.ic_weather_sunny)
//                    .priority(Picasso.Priority.HIGH)
//                    .fit()
//
//                    .into(imageView_condition_icon_future)
//
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }

        GlideApp.with(this.containerView)
//                .load("http:" + weatherEntry.conditionIconUrl)
            .load("http://openweathermap.org/img/wn/" + "$picturesUrl" + "@2x" + ".png")
//                .load("https://assets.weatherstack.com/images/wsymbols01_png_64/wsymbol_0008_clear_sky_night.png")
            .into(imageView_condition_icon_future_list)
    }
}