package com.example.weather.domain.usecase

import com.example.weather.data.model.request.WeatherRequest
import com.example.weather.data.model.response.WeatherForecastEntityResponse
import com.example.weather.data.repository.WeatherRepository
import javax.inject.Inject

class WeatherUseCase @Inject constructor(
    var weatherRepository: WeatherRepository
) {
    suspend fun getWeatherForecastByCoordinates(weatherRequest: WeatherRequest):
            WeatherForecastEntityResponse = weatherRepository.getWeatherForecastByCoordinates(weatherRequest)

}