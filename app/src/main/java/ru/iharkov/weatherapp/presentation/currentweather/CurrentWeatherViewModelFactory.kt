package ru.iharkov.weatherapp.presentation.currentweather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.iharkov.weatherapp.data.repository.FakeWeatherRepository

class CurrentWeatherViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(CurrentWeatherViewModel::class.java)) {
            val viewModel = CurrentWeatherViewModel(FakeWeatherRepository()) as T
            return viewModel
        } else{
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
