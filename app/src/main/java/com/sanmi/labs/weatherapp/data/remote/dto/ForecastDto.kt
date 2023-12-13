package com.sanmi.labs.weatherapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ForecastDto(
    @SerializedName("forecastday")
    val forecasts: List<ForecastDayDto>?
)
