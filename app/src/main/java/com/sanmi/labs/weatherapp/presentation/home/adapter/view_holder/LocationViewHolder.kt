package com.sanmi.labs.weatherapp.presentation.home.adapter.view_holder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sanmi.labs.bold.weather_app.databinding.ItemLocationBinding
import com.sanmi.labs.weatherapp.domain.model.Location

class LocationViewHolder private constructor(
    private val binding: ItemLocationBinding
) : RecyclerView.ViewHolder(binding.root) {

    lateinit var location: Location

    fun bind(location: Location) {
        this.location = location
        binding.location = location
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): LocationViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemLocationBinding.inflate(layoutInflater, parent, false)

            return LocationViewHolder(binding)
        }
    }
}