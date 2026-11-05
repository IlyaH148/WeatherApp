package ru.iharkov.weatherapp.presentation.currentweather

sealed interface CurrentWeatherUiState {

    data object Loading : CurrentWeatherUiState

    data class Content(
        val weather: WeatherUiModel
    ) : CurrentWeatherUiState

    data class Error(
        val message: String
    ) : CurrentWeatherUiState
}