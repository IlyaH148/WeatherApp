package ru.iharkov.weatherapp.presentation.currentweather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.iharkov.weatherapp.domain.model.Weather
import ru.iharkov.weatherapp.domain.model.WeatherCondition
import ru.iharkov.weatherapp.domain.repository.WeatherRepository

class CurrentWeatherViewModel(
    private val repository: WeatherRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<CurrentWeatherUiState>(
        value = CurrentWeatherUiState.Loading
    )
    val uiState = _uiState.asStateFlow()

    fun loadWeather(){
        _uiState.value = CurrentWeatherUiState.Loading
        viewModelScope.launch {
            delay(1500)
            val weather = repository.getWeather()
            val weatherUiModel = mapWeatherToUi(weather)
            _uiState.value = CurrentWeatherUiState.Content(weatherUiModel)
        }
    }
}

