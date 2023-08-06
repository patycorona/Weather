package com.example.weather.data.repository

import com.example.weather.data.model.request.WeatherRequest
import com.example.weather.data.model.response.WeatherForecastEntityResponse

interface WeatherRepository {

    suspend fun getWeatherForecastByCoordinates(weatherRequest: WeatherRequest):
            WeatherForecastEntityResponse

}