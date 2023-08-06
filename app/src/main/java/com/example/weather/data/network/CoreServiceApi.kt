package com.example.weather.data.network

import com.example.weather.data.model.mapping.ConstantGeneral.APP_ID_PARAM
import com.example.weather.data.model.mapping.ConstantGeneral.EXCLUDE_PARAM
import com.example.weather.data.model.mapping.ConstantGeneral.LANGUAGE_PARAM
import com.example.weather.data.model.mapping.ConstantGeneral.LATITUDE_PARAM
import com.example.weather.data.model.mapping.ConstantGeneral.LONGITUDE_PARAM
import com.example.weather.data.model.mapping.ConstantGeneral.UNITS_PARAM
import com.example.weather.data.model.response.WeatherForecastEntityResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface CoreServiceApi {
    @GET("/data/2.5/onecall")
   @Headers("Content-Type: application/json ")
    suspend fun getWeatherForecastByCoordinates(
        @Query(LATITUDE_PARAM) lat: Double,
        @Query(LONGITUDE_PARAM) lon: Double,
        @Query(APP_ID_PARAM) appId: String,
        @Query(EXCLUDE_PARAM) exclude: String,
        @Query(UNITS_PARAM) units: String,
        @Query(LANGUAGE_PARAM) lang: String
    ) : WeatherForecastEntityResponse
}