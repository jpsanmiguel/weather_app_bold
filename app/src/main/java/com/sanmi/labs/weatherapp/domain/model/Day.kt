package com.sanmi.labs.weatherapp.domain.model

data class Day(
    val maxTemperatureCelsius: Double = 0.0,
    val minTemperatureCelsius: Double = 0.0,
    val averageTemperatureCelsius: Double = 0.0,
    val maxWindKph: Double = 0.0,
    val averageHumidity: Double = 0.0,
    val condition: Condition = Condition(),
    val uv: Int = 0
)
