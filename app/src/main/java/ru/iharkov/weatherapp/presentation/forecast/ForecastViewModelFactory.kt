package ru.iharkov.weatherapp.presentation.forecast

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.iharkov.weatherapp.data.repository.FakeWeatherRepository

class ForecastViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(ForecastViewModel::class.java)) {
            val viewModel = ForecastViewModel(FakeWeatherRepository()) as T
            return viewModel
        } else{
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
