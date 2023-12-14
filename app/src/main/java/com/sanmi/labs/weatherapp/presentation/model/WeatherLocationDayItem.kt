package com.sanmi.labs.weatherapp.presentation.model

data class WeatherLocationDayItem(
    val date: String,
    val maxTemperatureCelsius: Double,
    val minTemperatureCelsius: Double,
    val averageTemperatureCelsius: Double,
    val conditionDescription: String,
    val conditionImage: String,
    val sunrise: String,
    val sunset: String,
    val moonrise: String,
    val moonSet: String,
    val moonPhase: String,
    val hours: List<HourItem>
)
