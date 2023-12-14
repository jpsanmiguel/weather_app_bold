package com.sanmi.labs.weatherapp.core.util

sealed class Status {
    data object Loading: Status()
    data object Success: Status()
    data class Failed(val exception: Throwable): Status()
}
