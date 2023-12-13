package com.sanmi.labs.weatherapp.domain.model

data class Current(
    val lastUpdatedEpoch: Long = 0L,
    val lastUpdated: String = "",
    val temperatureCelsius: Double = 0.0,
    val feelsLikeCelsius: Double = 0.0,
    val isDay: Int = 0,
    val condition: Condition = Condition(),
    val windKph: Double = 0.0,
    val windDirection: String = "",
    val humidity: Int = 0,
    val visibilityKm: Double = 0.0,
    val uv: Double = 0.0
)
