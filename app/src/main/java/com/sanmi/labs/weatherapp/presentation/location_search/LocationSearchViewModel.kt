package com.sanmi.labs.weatherapp.presentation.location_search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sanmi.labs.weatherapp.core.util.BaseViewModel
import com.sanmi.labs.weatherapp.core.util.Status
import com.sanmi.labs.weatherapp.domain.model.Location
import com.sanmi.labs.weatherapp.domain.use_case.SearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationSearchViewModel @Inject constructor(
    private val searchUseCase: SearchUseCase
) : BaseViewModel() {

    private var searchWeatherJob: Job? = null

    private val _locations = MutableLiveData<List<Location>>()
    val locations: LiveData<List<Location>>
        get() = _locations

    init {
        searchWeather("Bogo")
    }

    fun searchWeather(query: String) {
        searchWeatherJob?.cancel()
        _status.value = Status.Loading
        searchWeatherJob = viewModelScope.launch {
            searchUseCase.invoke(query).onSuccess {
                _locations.value = it
                _status.value = Status.Success
            }.onFailure {
                _status.value = Status.Failed(it)
            }
        }
    }
}