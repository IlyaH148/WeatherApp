package ru.iharkov.weatherapp.domain.model

import java.time.LocalDate

data class Forecast (
    val weatherCondition: WeatherCondition,
    val date: LocalDate,
    val temperature: Int,
)