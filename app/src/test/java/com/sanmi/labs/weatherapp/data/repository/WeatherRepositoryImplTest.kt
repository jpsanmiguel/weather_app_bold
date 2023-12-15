package com.sanmi.labs.weatherapp.data.repository

import com.sanmi.labs.weatherapp.data.remote.WeatherApi
import com.sanmi.labs.weatherapp.data.remote.validSearchResponse
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import com.google.common.truth.Truth.assertThat
import com.sanmi.labs.weatherapp.data.remote.malformedForecastResponse
import com.sanmi.labs.weatherapp.data.remote.malformedSearchResponse
import com.sanmi.labs.weatherapp.data.remote.validForecastResponse


class WeatherRepositoryImplTest {

    private lateinit var repository: WeatherRepositoryImpl
    private lateinit var mockWebServer: MockWebServer
    private lateinit var okHttpClient: OkHttpClient
    private lateinit var api: WeatherApi

    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        okHttpClient = OkHttpClient.Builder()
            .writeTimeout(1, TimeUnit.SECONDS)
            .readTimeout(1, TimeUnit.SECONDS)
            .connectTimeout(1, TimeUnit.SECONDS)
            .build()
        api = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .baseUrl(mockWebServer.url("/"))
            .build()
            .create(WeatherApi::class.java)
        repository = WeatherRepositoryImpl(api)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `Search weather, valid response, returns success`() = runBlocking {
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(validSearchResponse)
        )
        val result = repository.searchWeather("bogota")

        assertThat(result.isSuccess).isTrue()
    }

    @Test
    fun `Search weather, invalid response code, returns failure`() = runBlocking {
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(403)
                .setBody(validSearchResponse)
        )
        val result = repository.searchWeather("bogota")

        assertThat(result.isFailure).isTrue()
    }

    @Test
    fun `Search weather, invalid response, returns failure`() = runBlocking {
        mockWebServer.enqueue(
            MockResponse()
                .setBody(malformedSearchResponse)
        )
        val result = repository.searchWeather("bogota")

        assertThat(result.isFailure).isTrue()
    }

    @Test
    fun `Search forecast, valid response, returns success`() = runBlocking {
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(validForecastResponse)
        )
        val result = repository.forecast("bogota")

        assertThat(result.isSuccess).isTrue()
    }

    @Test
    fun `Search forecast, invalid response code, returns failure`() = runBlocking {
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(403)
                .setBody(validForecastResponse)
        )
        val result = repository.forecast("bogota")

        assertThat(result.isFailure).isTrue()
    }

    @Test
    fun `Search forecast, invalid response, returns failure`() = runBlocking {
        mockWebServer.enqueue(
            MockResponse()
                .setBody(malformedForecastResponse)
        )
        val result = repository.forecast("bogota")

        assertThat(result.isFailure).isTrue()
    }
}