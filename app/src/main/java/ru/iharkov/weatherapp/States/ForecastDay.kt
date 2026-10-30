package ru.iharkov.weatherapp.States

data class ForecastDay(
    val weatherState: WeatherState,
    val date: String,
    val temperature: String
)