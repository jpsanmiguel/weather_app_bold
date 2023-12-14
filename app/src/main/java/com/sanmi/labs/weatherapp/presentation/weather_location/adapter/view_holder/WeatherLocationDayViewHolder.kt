package com.sanmi.labs.weatherapp.presentation.weather_location.adapter.view_holder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sanmi.labs.bold.weather_app.databinding.ItemWeatherLocationDayBinding
import com.sanmi.labs.weatherapp.presentation.model.WeatherLocationDayItem

class WeatherLocationDayViewHolder private constructor(
    private val binding: ItemWeatherLocationDayBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(weatherLocationDayItem: WeatherLocationDayItem, locationFullName: String) {
        binding.weatherLocationDayItem = weatherLocationDayItem
        binding.locationFullName = locationFullName
    }

    companion object {
        fun from(parent: ViewGroup): WeatherLocationDayViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemWeatherLocationDayBinding.inflate(layoutInflater, parent, false)

            return WeatherLocationDayViewHolder(binding)
        }
    }
}