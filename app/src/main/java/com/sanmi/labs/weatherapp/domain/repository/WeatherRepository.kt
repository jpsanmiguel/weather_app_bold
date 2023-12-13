package com.sanmi.labs.weatherapp.domain.repository

import com.sanmi.labs.weatherapp.domain.model.Location

interface WeatherRepository {

    suspend fun searchWeather(query: String): Result<List<Location>>
}