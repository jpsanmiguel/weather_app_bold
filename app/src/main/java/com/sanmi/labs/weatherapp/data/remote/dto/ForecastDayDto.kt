package com.sanmi.labs.weatherapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ForecastDayDto(
    @SerializedName("date_epoch")
    val dateEpoch: Long?,
    val date: String?,
    val day: DayDto?,
    val astro: AstroDto?,
    @SerializedName("hour")
    val hours: List<HourDto>?
)