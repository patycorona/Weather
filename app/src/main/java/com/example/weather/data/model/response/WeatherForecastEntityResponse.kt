package com.example.weather.data.model.response

import com.google.gson.annotations.SerializedName

data class WeatherForecastEntityResponse(
    val timezone: String,
    val current: CurrentResponse,
    val hourly: List<ForecastResponse>?)



