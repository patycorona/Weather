package com.example.weather.data.model.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Weather(
    val main: String,
    val description: String
): Parcelable
