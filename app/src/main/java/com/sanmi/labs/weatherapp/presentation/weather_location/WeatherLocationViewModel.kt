package com.sanmi.labs.weatherapp.presentation.weather_location

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sanmi.labs.weatherapp.core.util.BaseViewModel
import com.sanmi.labs.weatherapp.core.util.Status
import com.sanmi.labs.weatherapp.domain.use_case.ForecastUseCase
import com.sanmi.labs.weatherapp.presentation.mapper.toWeatherLocationItem
import com.sanmi.labs.weatherapp.presentation.model.WeatherLocationItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherLocationViewModel @Inject constructor(
    private val forecastUseCase: ForecastUseCase
) : BaseViewModel() {

    private val _forecast = MutableLiveData<WeatherLocationItem>()
    val forecast: LiveData<WeatherLocationItem>
        get() = _forecast

    fun getForecastWeather(query: String) {
        _status.value = Status.Loading
        viewModelScope.launch {
            forecastUseCase.invoke(query).onSuccess {
                _forecast.value = it.toWeatherLocationItem()
                _status.value = Status.Success
            }.onFailure {
                _status.value = Status.Failed(it)
            }
        }
    }
}