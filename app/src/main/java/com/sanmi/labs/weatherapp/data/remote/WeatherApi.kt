package com.sanmi.labs.weatherapp.data.remote

import com.sanmi.labs.bold.weather_app.BuildConfig
import com.sanmi.labs.weatherapp.data.remote.dto.SearchDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("search.json")
    suspend fun search(
        @Query("q")
        query: String,
        @Query("key")
        key: String = BuildConfig.API_KEY
    ): List<SearchDto>

    companion object {
        const val BASE_URL = "https://api.weatherapi.com/v1/"
    }
}