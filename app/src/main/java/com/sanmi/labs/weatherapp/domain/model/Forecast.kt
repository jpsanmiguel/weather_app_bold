package com.sanmi.labs.weatherapp.domain.model

data class Forecast(
    val forecasts: List<ForecastDay> = emptyList()
)
