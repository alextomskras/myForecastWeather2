package com.dreamer.myweather2.ui.weather.future.list


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dreamer.myweather2.R
import com.dreamer.myweather2.data.db.LocalDateConverter
import com.dreamer.myweather2.data.db.unitlocalized.future.list.UnitSpecificSimpleFutureWeatherEntry
import com.dreamer.myweather2.ui.base.ScopedFragment
import com.xwray.groupie.GroupAdapter
//import com.xwray.groupie.GroupieViewHolder
//import com.xwray.groupie.GroupieViewHolder
//import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder

import kotlinx.android.synthetic.main.future_list_weather_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance
import org.threeten.bp.LocalDateTime

class FutureListWeatherFragment : ScopedFragment(), KodeinAware {

    override val kodein by closestKodein()
    private val viewModelFactory: FutureListWeatherViewModelFactory by instance()

    private lateinit var viewModel: FutureListWeatherViewModel

//    private lateinit var viewModelCurrent: CurrentWeatherViewModel

//    private val cityName : String   = MainActivity().nameCity

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.future_list_weather_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(FutureListWeatherViewModel::class.java)
//        viewModelCurrent = ViewModelProviders.of(this, viewModelFactory)
//                .get(CurrentWeatherViewModel::class.java)

        bindUI()
    }

    private fun bindUI() = launch(Dispatchers.Main) {
        val futureWeatherEntries = viewModel.weatherEntries.await()
        Log.e("bindUI", "bindUI:: " + futureWeatherEntries)
//        val currentWeatherEntries = viewModelCurrent.weather.await()
        Log.e("bindUI", "bindUI:: " + futureWeatherEntries)
        val weatherLocation = viewModel.weatherLocation.await()

//        currentWeatherEntries.observe(viewLifecycleOwner, Observer {currentWeatherEntries ->
//
//            if (currentWeatherEntries == null) return@Observer
//            group_loading.visibility = View.GONE
//            updateLocation(currentWeatherEntries.name)
//
//        })

        weatherLocation.observe(viewLifecycleOwner, Observer { location ->
//            if (location == null) return@Observer
//            updateLocation(location.id.toString()) .toInt().toString()

            updateLocation(getString(R.string.List_of_weather))
        })


        futureWeatherEntries.observe(
                viewLifecycleOwner,
                Observer { weatherEntries ->
                    Log.e("bindUI", "bindUI:: " + weatherEntries)
                    if (weatherEntries == null) return@Observer

                    group_loading.visibility = View.GONE
                    Log.e("updateDateToNextWeek", "updateDateToNextWeek:: $weatherEntries::::")



                    updateDateToNextWeek()
                    Log.e("initRecyclerView", "updateDateToNextWeek:: $weatherEntries::::")
                    initRecyclerView(weatherEntries.toFutureWeatherItems())
                }
        )
    }

    private fun updateLocation(location: String) {
        (activity as? AppCompatActivity)?.supportActionBar?.title = location
//        (activity as? AppCompatActivity)?.supportActionBar?.title = ""
//        MainActivity().nameCity = ""
    }

    private fun updateDateToNextWeek() {
        (activity as? AppCompatActivity)?.supportActionBar?.subtitle = getString(R.string.Next5Days)
    }

    private fun List<UnitSpecificSimpleFutureWeatherEntry>.toFutureWeatherItems(): List<FutureWeatherItem> {
        Log.e("toFutureWeather", "Items1:: $this@Future::::")
        return this.map {
            Log.e("toFutureWeather", "Items2: $it")
            FutureWeatherItem(it)
        }
    }




    //FutureWeatherItem
    private fun initRecyclerView(items: List<FutureWeatherItem>) {
        Log.e("initRecyclerView", "initRecyclerView:: $items::::")
        val groupAdapter = GroupAdapter<GroupieViewHolder>().apply {
            Log.e("initRecyclerView", "addAll:: $items::::")
            addAll(/* groups = */ items)
            notifyDataSetChanged()
        }

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@FutureListWeatherFragment.context)
            adapter = groupAdapter
        }

        groupAdapter.setOnItemClickListener { item, view ->
            (item as? FutureWeatherItem)?.let {
                showWeatherDetail(it.weatherEntry.date, view)
            }
        }
    }

    private fun showWeatherDetail(date: LocalDateTime, view: View) {
        val dateString = LocalDateConverter.dateToString(date)!!
        Log.e("showWeatherDetail", "dateString:: $dateString")
        val actionDetail = FutureListWeatherFragmentDirections.actionDetail(dateString)
        Navigation.findNavController(view).navigate(actionDetail)
    }


}
