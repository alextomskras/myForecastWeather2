package com.dreamer.myweather2.ui.weather.future.list


//import com.xwray.groupie.Item
//import com.xwray.groupie.kotlinandroidextensions.Item
//import com.xwray.groupie.kotlinandroidextensions.ViewHolder
//import kotlinx.android.synthetic.main.item_future_weather.*
import android.view.View
import com.bumptech.glide.Glide
import com.dreamer.myweather2.R
import com.dreamer.myweather2.data.db.unitlocalized.future.list.MetricSimpleFutureWeatherEntry
import com.dreamer.myweather2.data.db.unitlocalized.future.list.UnitSpecificSimpleFutureWeatherEntry
import com.dreamer.myweather2.databinding.ItemFutureWeatherBinding
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.FormatStyle


//class FutureWeatherItem(
//    val weatherEntry: UnitSpecificSimpleFutureWeatherEntry,
//    private val view: View // Add the view parameter to the constructor
//) : Item<GroupieViewHolder>() {
//    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
//        val context = AppCompatActivity()
//
//        viewHolder.apply {
//            val textView_condition = view.findViewById<TextView>(R.id.textView_condition)
//
//            val arr = arrayOf(weatherEntry.conditionText)
//            textView_condition.text = weatherEntry.conditionText.last().description.toString()
////            textView_condition.text = weatherEntry.conditionText[3].toString()
//            Log.e("fun bind", "from with1 $weatherEntry")
////            textView_condition.text = "weatherEntry.conditionText"
////            try {
////                Picasso.get()
//////                    .isLoggingEnabled
////
//////                        .load("${iconUrl}")
////                        .load("https://openweathermap.org/img/wn/01n.png")
//////                    .load("http://openweathermap.org/img/wn/" + "$picturesUrl"+ ".png")
//////                    .load("http://openweathermap.org/img/wn/" + "01n" + "@2x" + ".png")
//////                        .load("https://assets.weatherstack.com/images/wsymbols01_png_64/wsymbol_0008_clear_sky_night.png")
////                        .placeholder(R.drawable.common_google_signin_btn_icon_dark)
////                        .error(R.drawable.ic_weather_sunny)
////                        .fit()
////                        .into(imageView_condition_icon_future)
////            } catch (e: Exception) {
////                e.printStackTrace()
////            }
////                GlideApp.with(this.containerView)
//////                .load("http:" + weatherEntry.conditionIconUrl)
//////                .load("http://openweathermap.org/img/wn/" + "$picturesUrl" + "@2x" + ".png")
////                        .asBitmap()
////                        .load("http://assets.weatherstack.com/images/wsymbols01_png_64/wsymbol_0008_clear_sky_night.png")
////                        .placeholder(R.drawable.common_google_signin_btn_icon_dark)
////                        .error(R.drawable.ic_weather_sunny)
////                        .into(imageView_condition_icon_future)
////            }
//            updateDate()
//            updateTemperature()
//            updateConditionImage()
//
//        }
//    }
//
//    override fun getLayout() = R.layout.item_future_weather
//
//    private fun updateDate() {
//
////        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
////        val dtFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
//        val dtFormatter = DateTimeFormatter.ofPattern("dd-MM HH:mm")
//        val textView_date = view.findViewById<TextView>(R.id.textView_date)
//        textView_date.text = weatherEntry.date.format(dtFormatter)
////        textView_date.text = "weatherEntry"
//    }
//
//    private fun updateTemperature() {
//        val unitAbbreviation = if (weatherEntry is MetricSimpleFutureWeatherEntry) "°C"
//        else "°F"
//        val textView_temperature = view.findViewById<TextView>(R.id.textView_temperature)
//
//        textView_temperature.text = "${weatherEntry.avgTemperature.toInt()}$unitAbbreviation"
////        textView_temperature.text = "14.2$unitAbbreviation"
//    }
//
//    private fun updateConditionImage() {
//        val picturesUrl = weatherEntry.conditionText.last().icon.toString()
//        val iconUrl = "https://openweathermap.org/img/wn/" + "$picturesUrl" + "@2x" + ".png"
//        Log.e(this.toString(), "from picturesUrl error code: $picturesUrl")
//        Log.e(this.toString(), "from iconUrl error code: $iconUrl")
////        try {
////            Picasso.get()
////
//////                    .isLoggingEnabled
////
////                        .load(iconUrl)
//////                    .load("http://www.weatherbit.io/static/img/icons/r01d.png")
//////                    .load("https://goo.gl/32YN2B")
//////                    .load("http://openweathermap.org/img/wn/" + "$picturesUrl"+ ".png")
//////                    .load("https://openweathermap.org/img/wn/" + "01n" + "@2x" + ".png")
//////                        .load("https://assets.weatherstack.com/images/wsymbols01_png_64/wsymbol_0008_clear_sky_night.png")
////                    .placeholder(R.drawable.common_google_signin_btn_icon_dark)
////                    .error(R.drawable.ic_weather_sunny)
////                    .priority(Picasso.Priority.HIGH)
////                    .fit()
////
////                    .into(imageView_condition_icon_future)
////
////        } catch (e: Exception) {
////            e.printStackTrace()
////        }
//        val imageView_condition_icon_future_list = view.findViewById<ImageView>(R.id.imageView_condition_icon_future_list)
//        GlideApp.with(this.view)
////                .load("http:" + weatherEntry.conditionIconUrl)
//            .load("http://openweathermap.org/img/wn/" + "$picturesUrl" + "@2x" + ".png")
////                .load("https://assets.weatherstack.com/images/wsymbols01_png_64/wsymbol_0008_clear_sky_night.png")
//
//            .into(imageView_condition_icon_future_list)
//    }
//}

class FutureWeatherItem(
    private val binding: ItemFutureWeatherBinding,
    val weatherEntry: UnitSpecificSimpleFutureWeatherEntry,
) : Item<GroupieViewHolder>() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        val binding = ItemFutureWeatherBinding.bind(viewHolder.itemView)
        binding.apply {

            binding.textViewDate.text =
                weatherEntry.date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM))
            binding.textViewCondition.text = weatherEntry.conditionText.last().description
            val unitAbbreviation =
                if (weatherEntry is MetricSimpleFutureWeatherEntry) "°C" else "°F"
            binding.textViewTemperature.text =
                "${weatherEntry.avgTemperature.toInt()}$unitAbbreviation"
            Glide.with(viewHolder.itemView)
                .load(getIconUrl(weatherEntry.conditionText.last().icon))
                .into(binding.imageViewConditionIconFutureList)
        }
    }

    override fun getLayout(): Int {
        return R.layout.item_future_weather
    }

    private fun getIconUrl(iconCode: String): String {
        return "https://openweathermap.org/img/wn/$iconCode.png"
    }

    fun initializeViewBinding(view: View): ItemFutureWeatherBinding {
        return ItemFutureWeatherBinding.bind(view)
    }
}