package com.sanmi.labs.weatherapp.domain.model

data class ForecastDay(
    val dateEpoch: Long,
    val date: String,
    val day: Day,
    val astro: Astro,
    val hours: List<Hour>
)
