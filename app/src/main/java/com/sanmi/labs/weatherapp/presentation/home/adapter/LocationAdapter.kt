package com.sanmi.labs.weatherapp.presentation.home.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.sanmi.labs.weatherapp.domain.model.Location
import com.sanmi.labs.weatherapp.presentation.home.adapter.view_holder.LocationViewHolder

class LocationAdapter(private val onClickListener: OnClickListener) : ListAdapter<Location, LocationViewHolder>(LocationItemDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        return LocationViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        val location = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(location)
        }
        holder.bind(location)
    }

    object LocationItemDiffCallback : DiffUtil.ItemCallback<Location>() {
        override fun areItemsTheSame(oldItem: Location, newItem: Location): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Location, newItem: Location): Boolean {
            return oldItem == newItem
        }

    }

    class OnClickListener(val clickListener: (location: Location) -> Unit) {
        fun onClick(location: Location) = clickListener(location)
    }
}