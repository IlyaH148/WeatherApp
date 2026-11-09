package ru.iharkov.weatherapp.presentation.currentweather.states

data class ForecastDay(
    val weatherState: WeatherState,
    val date: String,
    val temperature: String
)