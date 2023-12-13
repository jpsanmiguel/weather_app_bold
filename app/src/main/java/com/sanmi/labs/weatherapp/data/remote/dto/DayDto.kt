package com.sanmi.labs.weatherapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class DayDto(
    @SerializedName("maxtemp_c")
    val maxTemperatureCelsius: Double?,
    @SerializedName("mintemp_c")
    val minTemperatureCelsius: Double?,
    @SerializedName("avgtemp_c")
    val averageTemperatureCelsius: Double?,
    @SerializedName("maxwind_kph")
    val maxWindKph: Double?,
    @SerializedName("avghumidity")
    val averageHumidity: Double?,
    val condition: ConditionDto?,
    val uv: Int?
)