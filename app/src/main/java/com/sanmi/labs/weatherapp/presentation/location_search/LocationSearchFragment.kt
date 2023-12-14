package com.sanmi.labs.weatherapp.presentation.location_search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.sanmi.labs.bold.weather_app.databinding.FragmentLocationSearchBinding
import com.sanmi.labs.weatherapp.core.util.Status
import com.sanmi.labs.weatherapp.presentation.location_search.adapter.LocationAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocationSearchFragment : Fragment() {

    private val locationSearchViewModel: LocationSearchViewModel by viewModels()

    private lateinit var binding: FragmentLocationSearchBinding

    private lateinit var locationAdapter: LocationAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLocationSearchBinding.inflate(inflater)

        binding.viewModel = locationSearchViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        locationAdapter = LocationAdapter(LocationAdapter.OnClickListener {
            // TODO implement
        })
        binding.locationRecyclerView.apply {
            adapter = locationAdapter
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        locationSearchViewModel.status.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = it is Status.Loading
            binding.locationRecyclerView.isVisible = it is Status.Success
        }

        locationSearchViewModel.locations.observe(viewLifecycleOwner) {
            locationAdapter.submitList(it)
        }
    }
}