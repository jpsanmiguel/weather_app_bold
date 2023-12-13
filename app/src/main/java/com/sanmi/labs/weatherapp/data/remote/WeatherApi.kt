package com.sanmi.labs.weatherapp.data.remote

import com.sanmi.labs.bold.weather_app.BuildConfig
import com.sanmi.labs.weatherapp.data.remote.dto.ForecastResultDto
import com.sanmi.labs.weatherapp.data.remote.dto.SearchLocationDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("search.json")
    suspend fun search(
        @Query("q")
        query: String,
        @Query("key")
        key: String = BuildConfig.API_KEY
    ): List<SearchLocationDto>

    @GET("forecast.json")
    suspend fun getWeatherForecast(
        @Query("q")
        query: String,
        @Query("days")
        days: Int = FORECAST_DAYS,
        @Query("key")
        key: String = BuildConfig.API_KEY
    ): ForecastResultDto

    companion object {
        const val BASE_URL = "https://api.weatherapi.com/v1/"
        const val FORECAST_DAYS = 3
    }
}