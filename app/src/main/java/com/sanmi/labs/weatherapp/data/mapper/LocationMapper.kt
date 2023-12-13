package com.sanmi.labs.weatherapp.data.mapper

import com.sanmi.labs.weatherapp.data.remote.dto.ForecastLocationDto
import com.sanmi.labs.weatherapp.data.remote.dto.SearchLocationDto
import com.sanmi.labs.weatherapp.domain.model.Location

fun SearchLocationDto.toLocation() = Location(
    id = id ?: 0,
    name = name.orEmpty(),
    region = region.orEmpty(),
    country = country.orEmpty(),
    latitude = lat ?: 0.0,
    longitude = lon ?: 0.0,
    url = url.orEmpty()
)

fun ForecastLocationDto.toLocation() = Location(
    name = name.orEmpty(),
    region = region.orEmpty(),
    country = country.orEmpty(),
    latitude = lat ?: 0.0,
    longitude = lon ?: 0.0,
    timezoneId = timezoneId.orEmpty(),
    localtimeEpoch = localtimeEpoch ?: 0L,
    localtime = localtime.orEmpty()
)