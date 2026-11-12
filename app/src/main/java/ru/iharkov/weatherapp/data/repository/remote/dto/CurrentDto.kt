package ru.iharkov.weatherapp.data.repository.remote.dto

data class CurrentDto(
    val datetime: String,
    val temp: Double,
    val humidity: Double,
    val pressure: Double,
    val windspeed: Double,
    val icon: String,
)