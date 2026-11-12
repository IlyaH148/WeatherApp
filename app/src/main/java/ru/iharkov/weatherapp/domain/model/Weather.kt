package ru.iharkov.weatherapp.domain.model

import java.time.LocalTime

data class Weather(
    val time: LocalTime,
    val temperature: Int,
    val weatherCondition: WeatherCondition,
    val windSpeed: Double,
    val pressure: Int,
    val humidity: Int,
)



