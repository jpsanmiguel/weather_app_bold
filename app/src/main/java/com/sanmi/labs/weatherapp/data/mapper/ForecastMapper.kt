package com.sanmi.labs.weatherapp.data.mapper

import com.sanmi.labs.weatherapp.data.remote.dto.AstroDto
import com.sanmi.labs.weatherapp.data.remote.dto.ConditionDto
import com.sanmi.labs.weatherapp.data.remote.dto.CurrentDto
import com.sanmi.labs.weatherapp.data.remote.dto.DayDto
import com.sanmi.labs.weatherapp.data.remote.dto.ForecastDayDto
import com.sanmi.labs.weatherapp.data.remote.dto.ForecastDto
import com.sanmi.labs.weatherapp.data.remote.dto.ForecastResultDto
import com.sanmi.labs.weatherapp.data.remote.dto.HourDto
import com.sanmi.labs.weatherapp.domain.model.Astro
import com.sanmi.labs.weatherapp.domain.model.Condition
import com.sanmi.labs.weatherapp.domain.model.Current
import com.sanmi.labs.weatherapp.domain.model.Day
import com.sanmi.labs.weatherapp.domain.model.Forecast
import com.sanmi.labs.weatherapp.domain.model.ForecastResult
import com.sanmi.labs.weatherapp.domain.model.ForecastDay
import com.sanmi.labs.weatherapp.domain.model.Hour
import com.sanmi.labs.weatherapp.domain.model.Location

fun ForecastResultDto.toForecast() = ForecastResult(
    location?.toLocation() ?: Location(),
    current?.toCurrent() ?: Current(),
    forecast?.toForecast() ?: Forecast()
    )

fun ConditionDto.toCondition() = Condition(
    text.orEmpty(),
    icon.orEmpty(),
    code ?: 0
)

fun CurrentDto.toCurrent() = Current(
    lastUpdatedEpoch ?: 0L,
    lastUpdated.orEmpty(),
    temperatureCelsius ?: 0.0,
    feelsLikeCelsius ?: 0.0,
    isDay ?: 0,
    condition?.toCondition() ?: Condition(),
    windKph ?: 0.0,
    windDirection.orEmpty(),
    humidity ?: 0,
    visibilityKm ?: 0.0,
    uv ?: 0.0
)

fun DayDto.toDay() = Day(
    maxTemperatureCelsius ?: 0.0,
    minTemperatureCelsius ?: 0.0,
    averageTemperatureCelsius ?: 0.0,
    maxWindKph ?: 0.0,
    averageHumidity ?: 0.0,
    condition?.toCondition() ?: Condition(),
    uv ?: 0
)

fun AstroDto.toAstro() = Astro(
    sunrise.orEmpty(),
    sunset.orEmpty(),
    moonrise.orEmpty(),
    moonSet.orEmpty(),
    moonPhase.orEmpty()
)

fun HourDto.toHour() = Hour(
    timeEpoch ?: 0L,
    time.orEmpty(),
    temperatureCelsius ?: 0.0,
    feelsLikeCelsius ?: 0.0,
    isDay ?: 0,
    condition?.toCondition() ?: Condition(),
    windKph.orEmpty(),
    windDirection.orEmpty(),
    humidity ?: 0,
    visibilityKm ?: 0.0,
    uv ?: 0.0
)

fun List<HourDto>.toHours() = map { it.toHour() }

fun ForecastDayDto.toForecastDay() = ForecastDay(
    dateEpoch ?: 0L,
    date.orEmpty(),
    day?.toDay() ?: Day(),
    astro?.toAstro() ?: Astro(),
    hours?.toHours() ?: emptyList()
)

fun List<ForecastDayDto>.toForecastDays() = this.map { it.toForecastDay() }

fun ForecastDto.toForecast() = Forecast(
    forecasts?.toForecastDays() ?: emptyList()
)