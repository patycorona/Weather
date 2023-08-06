package com.example.weather.data.model.response

open class WeatherBase (
    dt: Long,
    humidity: Int,
    temp: Double,
    weather: List<Weather>)