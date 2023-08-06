package com.example.weather.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.R
import com.example.weather.data.model.request.WeatherRequest
import com.example.weather.data.model.response.WeatherForecastEntityResponse
import com.example.weather.domain.usecase.WeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    var weatherUseCase: WeatherUseCase
) : ViewModel(){

    private val result = MutableLiveData<WeatherForecastEntityResponse>()
    fun getResult(): LiveData<WeatherForecastEntityResponse> = result


    private val snackbarMsg = MutableLiveData<Int>()
    fun getSnackbarMsg() = snackbarMsg
    private val loaded = MutableLiveData<Boolean>()
    fun isLoaded() = loaded

    suspend fun getWeatherForecastByCoordinates(weatherForecastBCRequest: WeatherRequest){
        viewModelScope.launch{
            try {
                loaded.value = false
                val resultServer =
                    weatherUseCase.getWeatherForecastByCoordinates(weatherForecastBCRequest)
                result.value = resultServer
                if (resultServer.hourly.isNullOrEmpty())
                    snackbarMsg.value = R.string.main_error_empty_forecast

            } catch (e: Exception) {
                snackbarMsg.value = R.string.main_error_empty_forecast
            } finally {
                loaded.value = true
            }
        }
    }
}