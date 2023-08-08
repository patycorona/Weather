package com.example.weather.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weather.R
import com.example.weather.BR
import com.example.weather.data.model.mapping.ConstantGeneral.APP_ID
import com.example.weather.data.model.mapping.ConstantGeneral.EXCLUDE
import com.example.weather.data.model.mapping.ConstantGeneral.LANGUAGE
import com.example.weather.data.model.mapping.ConstantGeneral.LATITUDE
import com.example.weather.data.model.mapping.ConstantGeneral.LONGITUDE
import com.example.weather.data.model.mapping.ConstantGeneral.UNITS
import com.example.weather.data.model.request.WeatherRequest
import com.example.weather.data.model.response.ForecastResponse
import com.example.weather.databinding.ActivityMainBinding
import com.example.weather.domain.model.Utils
import com.example.weather.ui.view.adapter.ForecastAdapter
import com.example.weather.ui.view.adapter.OnClickListener
import com.example.weather.ui.viewmodel.WeatherViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ForecastAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setupViewModel()
        setupObservers()
        setupAdapter()
        setupRecyclerView()
    }

    private fun setupViewModel() {
        val vm: WeatherViewModel by viewModels()
        binding.lifecycleOwner = this
        binding.setVariable(BR.viewModel,vm)
    }

    private fun setupObservers() {
        binding.viewModel?.let {
            it.getSnackbarMsg().observe(this){ resMsg ->
                Snackbar.make(binding.root, resMsg, Snackbar.LENGTH_LONG).show()
            }
            it.getResult().observe(this){ result ->
                adapter.submitList(result.hourly)
            }
        }
    }

    private fun setupAdapter(){
        adapter = ForecastAdapter(this)
    }

    private fun setupRecyclerView(){
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }
    }

    override fun onStart() {
        super.onStart()
        lifecycleScope.launch {
            binding.viewModel?.getWeatherForecastByCoordinates(
                WeatherRequest(LATITUDE,LONGITUDE,
                    APP_ID, EXCLUDE,
                    UNITS, LANGUAGE)
            )
        }
    }

    override fun onClick(forecast: ForecastResponse) {
        Snackbar.make(binding.root, Utils.getFullDate(forecast.dt), Snackbar.LENGTH_LONG).show()
    }
}