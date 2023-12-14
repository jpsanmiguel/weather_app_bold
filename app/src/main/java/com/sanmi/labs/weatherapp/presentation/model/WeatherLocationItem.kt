package com.sanmi.labs.weatherapp.presentation.model

data class WeatherLocationItem(
    val name: String,
    val region: String,
    val country: String,
    val temperatureCelsius: Double,
    val humidity: Int,
    val uv: Double,
    val wind: Double,
    val windDirection: String,
    val conditionDescription: String,
    val conditionImage: String,
    val weatherLocationDayItem: List<WeatherLocationDayItem>,
) {
    fun locationFullName() = "$name, $country"
}