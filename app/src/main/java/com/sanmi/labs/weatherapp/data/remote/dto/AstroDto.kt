package com.sanmi.labs.weatherapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class AstroDto(
    val sunrise: String?,
    val sunset: String?,
    val moonrise: String?,
    @SerializedName("moonset")
    val moonSet: String?,
    @SerializedName("moon_phase")
    val moonPhase: String?
)
