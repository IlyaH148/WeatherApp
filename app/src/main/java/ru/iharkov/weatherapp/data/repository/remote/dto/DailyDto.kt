package ru.iharkov.weatherapp.data.repository.remote.dto

import java.time.LocalDate

data class DailyDto(
    val time: List<String>,
    val weather_code: List<Int>,
    val temperature_2m_max: List<Double>
)