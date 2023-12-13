package com.sanmi.labs.weatherapp.domain.di

import com.sanmi.labs.weatherapp.domain.repository.WeatherRepository
import com.sanmi.labs.weatherapp.domain.use_case.ForecastUseCase
import com.sanmi.labs.weatherapp.domain.use_case.SearchUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    @Singleton
    internal fun provideSearchUseCase(
        weatherRepository: WeatherRepository
    ) = SearchUseCase(weatherRepository)

    @Provides
    @Singleton
    internal fun provideForecastUseCase(
        weatherRepository: WeatherRepository
    ) = ForecastUseCase(weatherRepository)
}