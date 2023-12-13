package com.sanmi.labs.weatherapp.data.repository

import com.sanmi.labs.weatherapp.data.mapper.toForecast
import com.sanmi.labs.weatherapp.data.mapper.toLocation
import com.sanmi.labs.weatherapp.data.remote.WeatherApi
import com.sanmi.labs.weatherapp.domain.model.ForecastResult
import com.sanmi.labs.weatherapp.domain.model.Location
import com.sanmi.labs.weatherapp.domain.repository.WeatherRepository

class WeatherRepositoryImpl(
    private val api: WeatherApi
) : WeatherRepository {
    override suspend fun searchWeather(query: String): Result<List<Location>> {
        return try {
            Result.success(api.search(query).map { it.toLocation() })
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun forecast(query: String): Result<ForecastResult> {
        return try {
            Result.success(api.getWeatherForecast(query).toForecast())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}