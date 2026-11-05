package ru.iharkov.weatherapp.domain.model

data class Weather(
    val temperature: Int,
    val weatherCondition: WeatherCondition,
    val windSpeed: Double,
    val pressure: Int,
    val humidity: Int,
)



