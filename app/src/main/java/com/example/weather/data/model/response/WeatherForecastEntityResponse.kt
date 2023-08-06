package com.example.weather.data.model.response

import com.google.gson.annotations.SerializedName

data class WeatherForecastEntityResponse(
    val timezone: String,
    val current: CurrentResponse,
    val hourly: List<ForecastResponse>?)

//data class WeatherForecastEntityResponse(
//    @SerializedName("timezone") val timezone:String = "",
//    @SerializedName("current") val current: CurrentModel = CurrentModel(),
//    @SerializedName("temp") val temp:Double = 0.0,
//    @SerializedName("hourly") val list_hourly: MutableList<ForecastResponse>? = mutableListOf()
//)


