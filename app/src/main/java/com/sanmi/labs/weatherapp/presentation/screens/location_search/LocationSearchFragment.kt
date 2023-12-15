package com.sanmi.labs.weatherapp.presentation.screens.location_search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sanmi.labs.bold.weather_app.R
import com.sanmi.labs.bold.weather_app.databinding.FragmentLocationSearchBinding
import com.sanmi.labs.weatherapp.core.util.CustomDividerItemDecorator
import com.sanmi.labs.weatherapp.core.util.Status
import com.sanmi.labs.weatherapp.presentation.screens.location_search.adapter.LocationAdapter
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

        binding.searchTextInputText.doOnTextChanged { text, _, _, _ ->
            text?.let { locationSearchViewModel.onSearchTextChange(text.toString()) }
        }

        locationAdapter = LocationAdapter(LocationAdapter.OnClickListener {
            findNavController().navigate(
                LocationSearchFragmentDirections.actionLocationSearchFragmentToWeatherLocationFragment(
                    "${it.name}, ${it.country}"
                )
            )
        })

        binding.locationRecyclerView.apply {
            adapter = locationAdapter
            addItemDecoration(
                CustomDividerItemDecorator(R.drawable.divider)
            )
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        locationSearchViewModel.status.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = it is Status.Loading
            binding.errorSection.isVisible = it is Status.Failed
            binding.successSection.isVisible = it is Status.Success
        }

        locationSearchViewModel.locations.observe(viewLifecycleOwner) {
            binding.locationRecyclerView.isVisible = it.isNotEmpty()
            binding.emptySection.isVisible = it.isEmpty()
            locationAdapter.submitList(it)
        }
    }
}