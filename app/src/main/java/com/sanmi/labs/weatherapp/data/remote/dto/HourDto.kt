package com.sanmi.labs.weatherapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class HourDto(
    @SerializedName("time_epoch")
    val timeEpoch: Long?,
    val time: String?,
    @SerializedName("temp_c")
    val temperatureCelsius: Double?,
    @SerializedName("feelslike_c")
    val feelsLikeCelsius: Double?,
    @SerializedName("is_day")
    val isDay: Int?,
    val condition: ConditionDto?,
    @SerializedName("wind_kph")
    val windKph: String?,
    @SerializedName("wind_dir")
    val windDirection: String?,
    val humidity: Int?,
    @SerializedName("vis_km")
    val visibilityKm: Double?,
    val uv: Double?
)
