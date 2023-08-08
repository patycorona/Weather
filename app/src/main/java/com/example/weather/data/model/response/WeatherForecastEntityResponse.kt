package com.example.weather.data.model.response

data class WeatherForecastEntityResponse(
    val timezone: String,
    val current: CurrentResponse,
    val hourly: List<ForecastResponse>?)



