package com.sanmi.labs.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.sanmi.labs.bold.weather_app.R
import com.sanmi.labs.weatherapp.domain.use_case.ForecastUseCase
import com.sanmi.labs.weatherapp.domain.use_case.SearchUseCase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var searchUseCase: SearchUseCase

    @Inject
    lateinit var forecastUseCase: ForecastUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            val searchResponse = searchUseCase("bogo")
            Log.d("Search Response:", searchResponse.toString())
            searchResponse.onSuccess {
                val forecastResponse = forecastUseCase(it[0].name)
                Log.d("Forecast Response:", forecastResponse.toString())

            }
        }
    }
}