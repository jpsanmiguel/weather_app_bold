package com.sanmi.labs.weatherapp.data.mapper

import com.sanmi.labs.weatherapp.data.remote.dto.SearchDto
import com.sanmi.labs.weatherapp.domain.model.Location

fun SearchDto.toLocation() = Location(
    id ?: 0,
    name.orEmpty(),
    region.orEmpty(),
    country.orEmpty(),
    lat ?: 0.0,
    lon ?: 0.0,
    url.orEmpty()
)