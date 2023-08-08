package com.example.weather.data.model.request

data class WeatherRequest(
    val lat: Double,
    val lon: Double,
    val appId: String,
    val exclude: String,
    val units: String,
    val lang: String
)

