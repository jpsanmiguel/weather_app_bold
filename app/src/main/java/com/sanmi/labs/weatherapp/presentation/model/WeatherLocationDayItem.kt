package com.sanmi.labs.weatherapp.presentation.model

import java.text.SimpleDateFormat
import java.util.Locale

data class WeatherLocationDayItem(
    val dateEpoch: Long,
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
) {
    val dateDisplayFormat: String = SimpleDateFormat("E, MMMM d", Locale.getDefault()).format(dateEpoch * 1000)
}
