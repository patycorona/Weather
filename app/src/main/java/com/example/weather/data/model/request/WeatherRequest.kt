package com.example.weather.data.model.request

data class WeatherRequest(
    val lat: Double,
    val lon: Double,
    val appId: String,
    val exclude: String,
    val units: String,
    val lang: String
)

/*
data class WeatherForecastbyCordinatesRequest(
    @SerializedName("lat") val lat: Double = 0.0,
    @SerializedName("lon") val lon: Double = 0.0,
    @SerializedName("appId") val appId: String = "",
    @SerializedName("exclude") val exclude: String = "",
    @SerializedName("units") val units: String = "",
    @SerializedName("lang") val lang: String = ""
)
*/
