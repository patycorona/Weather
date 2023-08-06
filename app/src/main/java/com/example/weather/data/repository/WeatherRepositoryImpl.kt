package com.example.weather.data.repository

import com.example.weather.data.model.request.WeatherRequest
import com.example.weather.data.model.response.WeatherForecastEntityResponse
import com.example.weather.data.network.CoreServiceApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(var coreServiceApi: CoreServiceApi):WeatherRepository {

    override suspend fun getWeatherForecastByCoordinates(weatherRequest: WeatherRequest):
            WeatherForecastEntityResponse = withContext(Dispatchers.IO) {
        coreServiceApi.getWeatherForecastByCoordinates(
            weatherRequest.lat,
            weatherRequest.lon,
            weatherRequest.appId,
            weatherRequest.exclude,
            weatherRequest.units,
            weatherRequest.lang
        )
    }



    /*override suspend fun getWeatherForecastByCoordinates(weatherForecastBCRequest: WeatherForecastbyCordinatesRequest
    ) : WeatherForescastEntityModel = withContext(Dispatchers.IO){
        coreServiceApi.getWeatherForecastByCoordinates(weatherForecastBCRequest).toModel()
    }*/

}