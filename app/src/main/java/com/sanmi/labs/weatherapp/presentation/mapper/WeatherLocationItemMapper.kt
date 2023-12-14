package com.sanmi.labs.weatherapp.presentation.mapper

import com.sanmi.labs.weatherapp.domain.model.ForecastDay
import com.sanmi.labs.weatherapp.domain.model.ForecastResult
import com.sanmi.labs.weatherapp.domain.model.Hour
import com.sanmi.labs.weatherapp.presentation.model.HourItem
import com.sanmi.labs.weatherapp.presentation.model.WeatherLocationDayItem
import com.sanmi.labs.weatherapp.presentation.model.WeatherLocationItem

fun ForecastResult.toWeatherLocationItem() = WeatherLocationItem(
    this.location.name,
    this.location.region,
    this.location.country,
    this.current.temperatureCelsius,
    this.current.humidity,
    this.current.uv,
    this.current.windKph,
    this.current.windDirection,
    this.current.condition.text,
    this.current.condition.icon,
    this.forecast.forecasts.toWeatherLocationDayItem()
)

fun ForecastDay.toWeatherLocationDayItem() = WeatherLocationDayItem(
    this.date,
    this.day.maxTemperatureCelsius,
    this.day.minTemperatureCelsius,
    this.day.averageTemperatureCelsius,
    this.day.condition.text,
    this.day.condition.icon,
    this.astro.sunrise,
    this.astro.sunset,
    this.astro.moonrise,
    this.astro.moonSet,
    this.astro.moonPhase,
    this.hours.toHourItem()
)

fun List<ForecastDay>.toWeatherLocationDayItem() = map { it.toWeatherLocationDayItem() }

fun Hour.toHourItem() = HourItem(
    this.time,
    this.temperatureCelsius,
    this.feelsLikeCelsius,
    this.condition.text,
    this.condition.icon
)

fun List<Hour>.toHourItem() = map { it.toHourItem() }