package com.sanmi.labs.weatherapp.domain.model

data class Location(
    val id: Int = 0,
    val name: String = "",
    val region: String = "",
    val country: String = "",
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val timezoneId: String = "",
    val localtimeEpoch: Long = 0L,
    val localtime: String = "",
    val url: String = ""
)