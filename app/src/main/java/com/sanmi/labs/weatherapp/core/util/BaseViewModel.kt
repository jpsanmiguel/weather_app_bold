package com.sanmi.labs.weatherapp.core.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
abstract class BaseViewModel : ViewModel() {
    protected val _status = MutableLiveData<Status>()
    val status: LiveData<Status>
        get() = _status
}