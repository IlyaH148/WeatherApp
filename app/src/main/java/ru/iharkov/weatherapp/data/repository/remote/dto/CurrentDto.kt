package ru.iharkov.weatherapp.data.repository.remote.dto

import java.time.LocalDate

data class CurrentDto(
    val time: String,
    val temperature_2m: Double,
    val relative_humidity_2m: Int,
    val surface_pressure: Double,
    val wind_speed_10m: Double,
    val weather_code: Int,
)