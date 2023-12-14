package com.sanmi.labs.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sanmi.labs.bold.weather_app.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}