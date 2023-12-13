package com.sanmi.labs.weatherapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ForecastLocationDto(
    val name: String?,
    val region: String?,
    val country: String?,
    val lat: Double?,
    val lon: Double?,
    @SerializedName("tz_id")
    val timezoneId: String?,
    @SerializedName("localtime_epoch")
    val localtimeEpoch: Long?,
    val localtime: String?
)
