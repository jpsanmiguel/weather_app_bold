package com.sanmi.labs.weatherapp.domain.model

data class ForecastResult(
    val location: Location = Location(),
    val current: Current = Current(),
    val forecast: Forecast = Forecast()
)
