package com.sanmi.labs.weatherapp.domain.use_case

import com.sanmi.labs.weatherapp.domain.model.Location
import com.sanmi.labs.weatherapp.domain.repository.WeatherRepository

class SearchUseCase(
    private val weatherRepository: WeatherRepository
) {

    suspend operator fun invoke(
        query: String
    ): Result<List<Location>> {
        return weatherRepository.searchWeather(query)
    }
}