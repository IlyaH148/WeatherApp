package ru.iharkov.weatherapp.states

data class ForecastDay(
    val weatherState: WeatherState,
    val date: String,
    val temperature: String
)