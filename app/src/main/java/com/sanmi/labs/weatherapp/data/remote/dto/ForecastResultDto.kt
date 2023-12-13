package com.sanmi.labs.weatherapp.data.remote.dto

data class ForecastResultDto(
    val location: ForecastLocationDto?,
    val current: CurrentDto?,
    val forecast: ForecastDto?
)