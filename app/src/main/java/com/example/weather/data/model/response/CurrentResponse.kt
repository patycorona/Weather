package com.example.weather.data.model.response

data class CurrentResponse(
    val dt: Long,
    val humidity: Int,
    val temp: Double,
    val weather: List<Weather>,
    val sunrise: Long
): WeatherBase(dt, humidity, temp, weather)


//@Parcelize
//data class CurrentModel(
//    val dt: Long = 0,
//    val humidity: Int = 0,
//    val temp: Double = 0.0,
//    val weather: MutableList<Weather> = mutableListOf(),
//    val sunrise: Long = 0
//): Parcelable