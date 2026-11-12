package ru.iharkov.weatherapp.presentation.currentweather

import ru.iharkov.weatherapp.presentation.common.states.WeatherState


data class WeatherUiModel(
    val time: String,
    val temperature: String,
    val weatherState: WeatherState,
    val windSpeed: String,
    val pressure: String,
    val humidity: String
)