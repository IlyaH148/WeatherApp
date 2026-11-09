package ru.iharkov.weatherapp.presentation.currentweather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.iharkov.weatherapp.domain.repository.WeatherRepository

class CurrentWeatherViewModelFactory(
    private val repository: WeatherRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(CurrentWeatherViewModel::class.java)) {
            val viewModel = CurrentWeatherViewModel(repository) as T
            return viewModel
        } else{
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
