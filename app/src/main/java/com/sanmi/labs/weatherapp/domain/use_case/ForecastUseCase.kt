package com.sanmi.labs.weatherapp.domain.use_case

import com.sanmi.labs.weatherapp.domain.model.ForecastResult
import com.sanmi.labs.weatherapp.domain.repository.WeatherRepository

class ForecastUseCase(
    private val weatherRepository: WeatherRepository
) {

    suspend operator fun invoke(
        query: String
    ): Result<ForecastResult> {
        return weatherRepository.forecast(query)
    }
}