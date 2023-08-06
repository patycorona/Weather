package com.example.weather.data.model.response


data class ForecastResponse(
    val dt: Long,
    val humidity: Int,
    val temp: Double,
    val weather: List<Weather>,
    val pop: Double
): WeatherBase(dt, humidity, temp, weather)

//@Parcelize
//data class ForecastResponse(
//    val dt: Long,
//    val humidity: Int,
//    val temp: Double,
//    val weather: List<Weather>,
//    val pop: Double
//): Parcelable
