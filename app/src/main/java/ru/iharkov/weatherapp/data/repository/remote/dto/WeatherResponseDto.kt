package ru.iharkov.weatherapp.data.repository.remote.dto

data class WeatherResponseDto(
    val currentConditions: CurrentDto,
    val days: List<DailyDto>
)