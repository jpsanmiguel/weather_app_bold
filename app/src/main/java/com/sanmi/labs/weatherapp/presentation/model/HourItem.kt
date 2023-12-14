package com.sanmi.labs.weatherapp.presentation.model

data class HourItem(
    val time: String,
    val temperatureCelsius: Double,
    val feelsLikeCelsius: Double,
    val conditionDescription: String,
    val conditionImage: String
)