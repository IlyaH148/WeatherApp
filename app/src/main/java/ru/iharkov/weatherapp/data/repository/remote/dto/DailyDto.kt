package ru.iharkov.weatherapp.data.repository.remote.dto

import java.time.LocalDate

data class DailyDto(
    val datetime: String,
    val tempmax: Double,
    val icon: String
)