package com.example.weather.ui.view.adapter

import com.example.weather.data.model.response.ForecastResponse

interface OnClickListener {
    fun onClick(forecast: ForecastResponse)
}