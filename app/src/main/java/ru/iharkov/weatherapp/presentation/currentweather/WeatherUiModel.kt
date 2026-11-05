package ru.iharkov.weatherapp.presentation.currentweather

import ru.iharkov.weatherapp.states.WeatherState

data class WeatherUiModel(
    val temperature: String,
    val weatherState: WeatherState,
    val windSpeed: String,
    val pressure: String,
    val humidity: String
)