package com.sanmi.labs.weatherapp.presentation.weather_location.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.sanmi.labs.weatherapp.presentation.model.WeatherLocationDayItem
import com.sanmi.labs.weatherapp.presentation.weather_location.adapter.view_holder.WeatherLocationDayViewHolder

class WeatherLocationDayAdapter(private val locationFullName: String) :
    ListAdapter<WeatherLocationDayItem, WeatherLocationDayViewHolder>(WeatherLocationItemDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherLocationDayViewHolder {
        return WeatherLocationDayViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: WeatherLocationDayViewHolder, position: Int) {
        val weatherLocationDayItem = getItem(position)
        holder.bind(weatherLocationDayItem, locationFullName)
    }

    object WeatherLocationItemDiffCallback : DiffUtil.ItemCallback<WeatherLocationDayItem>() {
        override fun areItemsTheSame(
            oldItem: WeatherLocationDayItem,
            newItem: WeatherLocationDayItem
        ): Boolean {
            return oldItem.date == newItem.date
        }

        override fun areContentsTheSame(
            oldItem: WeatherLocationDayItem,
            newItem: WeatherLocationDayItem
        ): Boolean {
            return oldItem == newItem
        }
    }
}