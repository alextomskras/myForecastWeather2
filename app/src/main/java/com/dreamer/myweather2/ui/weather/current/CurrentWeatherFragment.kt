package com.dreamer.myweather2.ui.weather.current

//import androidx.compose.foundation.layout.*
//import androidx.compose.material.MaterialTheme
//import androidx.compose.material.Scaffold
//import androidx.compose.material.Text
//import androidx.compose.material.TopAppBar
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.ComposeView
//import androidx.compose.ui.unit.dp
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.dreamer.myweather2.R
import com.dreamer.myweather2.ui.base.ScopedFragment
import com.squareup.picasso.Picasso
//import kotlinx.android.synthetic.*
//import kotlinx.android.synthetic.main.current_weather_fragment.*
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance
import org.threeten.bp.Instant
import org.threeten.bp.ZoneId
import org.threeten.bp.format.DateTimeFormatter


class CurrentWeatherFragment : ScopedFragment(), KodeinAware {

    override val kodein by closestKodein()


    private val viewModelFactory: CurrentWeatherViewModelFactory by instance()

    private lateinit var viewModel: CurrentWeatherViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.current_weather_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        clearFindViewByIdCache()
        val group_loading = view.findViewById<View>(R.id.group_loading)
        val imageView_condition_icon_future =
            view.findViewById<View>(R.id.imageView_condition_icon_future)

    }

//    private fun <T> findViewById(groupLoading: Int) {
//        findViewById<T>(groupLoading)
//    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(CurrentWeatherViewModel::class.java)

        bindUI()
    }

    private fun bindUI() = launch {
        val currentWeather = viewModel.weather.await()
//        val group_loading = clearFindViewByIdCache()

        val weatherLocation = viewModel.weatherLocation.await()

        weatherLocation.observe(viewLifecycleOwner, Observer { location ->
            if (location == null) return@Observer
//            updateLocation(location.lat.toInt())
            updateLocation(location.lat.toString())
        })

        currentWeather.observe(
            viewLifecycleOwner,
            Observer { curWeather ->
//                    if (currentWeather == null) return@Observer

                val group_loading = view?.findViewById<View>(R.id.group_loading)
                if (group_loading != null) {
                    group_loading.visibility = View.GONE
                }
                //правим заголовок окна - выставляем "Today"
                updateDateToToday()
                //Передаем значения температуры полученные из запроса
//            it?.main?.tempMin?.let { it1 -> updateTemperatures(it.main.temp.toInt().toString(), it.main.feelsLike.toInt().toString(), it.main.tempMin.toInt().toString(), it.main.tempMax.toInt().toString()) }
                updateTemperatures(
                    curWeather?.temperature?.toInt().toString(),
                    curWeather?.feelsLikeTemperature?.toInt().toString(),
                    curWeather.temperatureMin.toInt().toString(),
                    curWeather.temperatureMax.toInt().toString()
                )
                //Выводим в error-логи содержимое запроса
                Log.e(this.toString(), "from updateTemperatures: ${curWeather.temperature}")
//            updateTemperatures(22.1, 33.4)
                //Передаем описание погоды "например - мелкий дождь"
//            updateCondition(it.weather[0].description)
                updateCondition(curWeather.conditionText[0].description)
                //Выводим в error-логи содержимое запроса "it.futureWeather[0].description"
                Log.e(
                    this.toString(),
                    "from updateCondition: ${curWeather.conditionText[0].description}"
                )


                updateLocation(curWeather.name)

                updatePrecipitation(curWeather.pressureVolume)
                updateWind(curWeather.windDirection, curWeather.windSpeed.toInt().toString())
                updateVisibility(curWeather.visibilityDistance)
                updateSunrise(curWeather.sysSunrise)
                updateSunset(curWeather.sysSunset)
                val picturesUrl = curWeather.conditionText[0].icon

                Log.e(this.toString(), "from with2 error code: $picturesUrl")
                try {

                    val imageView_condition_icon_future =
                        view?.findViewById<ImageView>(R.id.imageView_condition_icon_future)

                    Picasso.get()
//                        .load("${picturesUrl}")
                        .load("http://openweathermap.org/img/wn/" + "$picturesUrl" + "@2x" + ".png")
//                        .load("https://assets.weatherstack.com/images/wsymbols01_png_64/wsymbol_0008_clear_sky_night.png")
                        .fit()
                        .into(imageView_condition_icon_future)
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }
        )
    }

    private fun chooseLocalizedUnitAbbreviation(metric: String, imperial: String): String {
        return if (viewModel.isMetricUnit) metric else imperial
    }

    private fun updateLocation(location: String) {
//        MainActivity().nameCity = location
        (activity as? AppCompatActivity)?.supportActionBar?.title = location.toString()
//        (activity as? AppCompatActivity)?.supportActionBar?.title = location.toString()
    }

    private fun updateDateToToday() {
        (activity as? AppCompatActivity)?.supportActionBar?.subtitle = getString(R.string.Curtoday)
    }

    //Change Double to String for truncate decmial stage of degrees
    private fun updateTemperatures(
        temperature: String,
        feelsLike: String,
        tempMin: String,
        tempMax: String,
    ) {
        val unitAbbreviation = chooseLocalizedUnitAbbreviation("°C", "°F")
        val textView_temperature = view?.findViewById<TextView>(R.id.textView_temperature)
        if (textView_temperature != null) {
            textView_temperature.text = "${temperature}" + "$unitAbbreviation"
        }
        val textView_min_max_temperature_current =
            view?.findViewById<TextView>(R.id.textView_min_max_temperature_current)
        if (textView_min_max_temperature_current != null) {
            textView_min_max_temperature_current.text =
                getString(R.string.futMin) + ": " + "$tempMin" + "$unitAbbreviation" + "," + getString(
                    R.string.futMax
                ) + ": " + "$tempMax" + "$unitAbbreviation"
        }
        val textView_feels_like_temperature =
            view?.findViewById<TextView>(R.id.textView_feels_like_temperature)
        if (textView_feels_like_temperature != null) {
            textView_feels_like_temperature.text =
                getString(R.string.curFeelslike) + ": " + "$feelsLike" + "$unitAbbreviation"
        }
    }

    private fun updateCondition(condition: String) {
        val textView_condition = view?.findViewById<TextView>(R.id.textView_condition)
        if (textView_condition != null) {
            textView_condition.text = condition
        }
    }

    private fun updatePrecipitation(precipitationVolume: Int) {
        val unitAbbreviation = chooseLocalizedUnitAbbreviation("mm", "in")
        val textView_precipitation = view?.findViewById<TextView>(R.id.textView_precipitation)
        if (textView_precipitation != null) {
            textView_precipitation.text =
                getString(R.string.futPressure) + ": $precipitationVolume $unitAbbreviation"
        }
    }

    //    Change Double to String for truncate decmial stage of degrees
    private fun updateWind(windDirection: String, windSpeed: String) {
        val unitAbbreviation = chooseLocalizedUnitAbbreviation("ms", "mph")
        val WindDirectionstoWords = transformWindDirectionstoWords(windDirection)

//        textView_wind.text = "Wind: $windDirection, $windSpeed $unitAbbreviation"
        val textView_wind = view?.findViewById<TextView>(R.id.textView_wind)
        if (textView_wind != null) {
            textView_wind.text =
                getString(R.string.CurWind) + ": $WindDirectionstoWords, $windSpeed" + " $unitAbbreviation"
        }
    }

    private fun transformWindDirectionstoWords(windDirection: String): String {


        return when (windDirection.toDouble()) {
            in 348.75..11.25 -> getString(R.string.North)
            in 11.25..33.75 -> getString(R.string.NorthNorthEast)
            in 33.75..56.25 -> getString(R.string.NorthEast)
            in 56.25..78.75 -> getString(R.string.EastNorthEast)
            in 78.75..101.25 -> getString(R.string.East)
            in 101.25..123.75 -> getString(R.string.EastSouthEast)
            in 123.75..146.25 -> getString(R.string.SouthEast)
            in 146.25..168.75 -> getString(R.string.SouthSouthEast)
            in 168.75..191.25 -> getString(R.string.South)
            in 191.25..213.75 -> getString(R.string.SouthSouthWest)
            in 213.75..236.25 -> getString(R.string.SouthWest)
            in 236.25..258.75 -> getString(R.string.WestSouthWest)
            in 258.75..281.25 -> getString(R.string.West)
            in 281.25..303.75 -> getString(R.string.WestNothWest)
            in 303.75..326.25 -> getString(R.string.NorthWest)
            in 326.25..348.75 -> getString(R.string.NorthNorthWest)
            else -> "not rated"

        }
    }

    private fun updateVisibility(visibilityDistance: Double) {
        val unitAbbreviation = chooseLocalizedUnitAbbreviation("m", "mi.")
        val textView_visibility = view?.findViewById<TextView>(R.id.textView_visibility)
        if (textView_visibility != null) {
            textView_visibility.text =
                getString(R.string.CurVisibility) + ": ${visibilityDistance.toInt()} $unitAbbreviation"
        }
    }

    private fun updateSunrise(sunriseTime: Double) {
        //превращаем секунды в нормальный формат даты
        val dt = Instant.ofEpochSecond(sunriseTime.toLong())
            .atZone(ZoneId.systemDefault())
//                .toLocalTime()
            .toLocalDateTime()
            .format(DateTimeFormatter.ISO_LOCAL_TIME)

        val unitAbbreviation = chooseLocalizedUnitAbbreviation("h", "m")
        val testTime1 = sunriseTime
        val textView_sunrise = view?.findViewById<TextView>(R.id.textView_sunrise)
        if (textView_sunrise != null) {
            textView_sunrise.text = getString(R.string.CurSunrise) + ": $dt"
        }
    }

    private fun updateSunset(sunsetTime: Double) {
        //превращаем секунды в нормальный формат даты
        val dt = Instant.ofEpochSecond(sunsetTime.toLong())
            .atZone(ZoneId.systemDefault())
            .toLocalTime()
            //                .toLocalDateTime()
            .format(DateTimeFormatter.ISO_LOCAL_TIME)

        val unitAbbreviation = chooseLocalizedUnitAbbreviation("h", "m")
        val testTime2 = sunsetTime
        val textView_sunset = view?.findViewById<TextView>(R.id.textView_sunset)
        if (textView_sunset != null) {
            textView_sunset.text = getString(R.string.CurSunset) + ": $dt "
        }
    }

}

//@AndroidEntryPoint
//class CurrentWeatherFragment : ComposeViewFragment() {
//
//    private val viewModel: CurrentWeatherViewModel by viewModels()
//    private val scaffoldState = rememberScaffoldState()
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        return ComposeView(requireContext()).apply {
//            setContent {
//                CurrentWeatherContent(viewModel)
//            }
//        }
//    }
//
//    @Composable
//    fun CurrentWeatherContent(viewModel: CurrentWeatherViewModel) {
//        val currentWeather by viewModel.weather.observeAsState(null)
//        val weatherLocation by viewModel.weatherLocation.observeAsState(null)
//
//        Scaffold(
//            scaffoldState = scaffoldState,
//            topBar = {
//                TopAppBar(
//                    title = {
//                        weatherLocation?.name?.let {
//                            Text(text = it)
//                        } ?: Text(text = getString(R.string.app_name))
//                    },
//                    navigationIcon = {
//                        IconButton(onClick = { requireActivity().onBackPressed() }) {
//                            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
//                        }
//                    }
//                )
//            }
//        ) {
//            Surface(
//                modifier = Modifier.fillMaxSize(),
//                color = MaterialTheme.colors.background
//            ) {
//                if (currentWeather != null && weatherLocation != null) {
//                    Column(
//                        modifier = Modifier.fillMaxSize(),
//                        horizontalAlignment = Alignment.CenterHorizontally
//                    ) {
//                        Text(
//                            text = currentWeather.temperature.toString() + "°C",
//                            style = MaterialTheme.typography.h1,
//                            fontWeight = FontWeight.Bold,
//                            modifier = Modifier.padding(top = 32.dp)
//                        )
//                        Text(
//                            text = currentWeather.conditionText[0].description,
//                            style = MaterialTheme.typography.h5,
//                            modifier = Modifier.padding(top = 8.dp)
//                        )
//                        Text(
//                            text = getString(R.string.futMin) + ": ${currentWeather.temperatureMin}°C, " +
//                                    getString(R.string.futMax) + ": ${currentWeather.temperatureMax}°C",
//                            style = MaterialTheme.typography.subtitle1,
//                            modifier = Modifier.padding(top = 16.dp)
//                        )
//                        // Add the other UI components here
//                    }
//                } else {
//                    Box(modifier = Modifier.fillMaxSize()) {
//                        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
//                    }
//                }
//            }
//        }
//    }
//}