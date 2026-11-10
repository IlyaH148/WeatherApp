package ru.iharkov.weatherapp.presentation.forecast

import ru.iharkov.weatherapp.presentation.common.states.WeatherState

data class ForecastDay(
    val weatherState: WeatherState,
    val date: String,
    val temperature: String
)