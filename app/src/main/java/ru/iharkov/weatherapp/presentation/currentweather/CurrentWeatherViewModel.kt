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

class CurrentWeatherViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<CurrentWeatherUiState>(
        value = CurrentWeatherUiState.Loading
    )
    val uiState = _uiState.asStateFlow()

    fun loadWeather(){
        _uiState.value = CurrentWeatherUiState.Loading
        viewModelScope.launch {
            delay(1500)
            val weather = Weather(
                temperature = 31,
                weatherCondition = WeatherCondition.CLOUDY,
                windSpeed = 4.5,
                pressure = 759,
                humidity = 42
            )
            val weatherUiModel = mapWeatherToUi(weather)
            _uiState.value = CurrentWeatherUiState.Content(weatherUiModel)
        }
    }
}

