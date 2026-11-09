package ru.iharkov.weatherapp.presentation.forecast

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.iharkov.weatherapp.domain.repository.WeatherRepository

class ForecastViewModelFactory(
    private val repository: WeatherRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(ForecastViewModel::class.java)) {
            val viewModel = ForecastViewModel(repository) as T
            return viewModel
        } else{
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
