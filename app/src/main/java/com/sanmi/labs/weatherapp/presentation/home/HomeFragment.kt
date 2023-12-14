package com.sanmi.labs.weatherapp.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.sanmi.labs.bold.weather_app.databinding.FragmentHomeBinding
import com.sanmi.labs.weatherapp.core.util.Status
import com.sanmi.labs.weatherapp.presentation.home.adapter.LocationAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()

    private lateinit var binding: FragmentHomeBinding

    private lateinit var locationAdapter: LocationAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)

        binding.viewModel = homeViewModel
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

        homeViewModel.status.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = it is Status.Loading
            binding.locationRecyclerView.isVisible = it is Status.Success
        }

        homeViewModel.locations.observe(viewLifecycleOwner) {
            locationAdapter.submitList(it)
        }
    }
}