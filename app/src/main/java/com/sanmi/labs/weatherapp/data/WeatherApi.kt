package com.sanmi.labs.weatherapp.data

import com.sanmi.labs.bold.weather_app.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("search.json")
    suspend fun search(
        @Query("q")
        query: String,
        @Query("key")
        key: String = BuildConfig.API_KEY
    ): List<Any>

    companion object {
        const val BASE_URL = "https://api.weatherapi.com/v1/"
    }
}