package com.sanmi.labs.weatherapp.data.remote.dto

data class SearchDto(
    val id: Int?,
    val name: String?,
    val region: String?,
    val country: String?,
    val lat: Double?,
    val lon: Double?,
    val url: String?
)
