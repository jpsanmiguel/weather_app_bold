package com.sanmi.labs.weatherapp.presentation.weather_location

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.sanmi.labs.bold.weather_app.databinding.FragmentWeatherLocationBinding
import com.sanmi.labs.weatherapp.core.util.Status
import com.sanmi.labs.weatherapp.presentation.weather_location.adapter.WeatherLocationDayAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherLocationFragment : Fragment() {

    private val weatherLocationViewModel: WeatherLocationViewModel by viewModels()

    private val args: WeatherLocationFragmentArgs by navArgs()

    private lateinit var binding: FragmentWeatherLocationBinding

    private lateinit var weatherLocationDayAdapter: WeatherLocationDayAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWeatherLocationBinding.inflate(inflater)

        binding.viewModel = weatherLocationViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        weatherLocationViewModel.getForecastWeather(args.locationName)

        weatherLocationDayAdapter = WeatherLocationDayAdapter()
        binding.weatherLocationRecyclerView.adapter = weatherLocationDayAdapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        weatherLocationViewModel.status.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = it is Status.Loading
            binding.successSection.isVisible = it is Status.Success
        }

        weatherLocationViewModel.forecast.observe(viewLifecycleOwner) {
            weatherLocationDayAdapter.submitList(it.weatherLocationDayItem)
        }
    }
}