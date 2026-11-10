package ru.iharkov.weatherapp.data.repository.remote.dto

data class WeatherResponseDto(
    val current: CurrentDto,
    val daily: DailyDto
)