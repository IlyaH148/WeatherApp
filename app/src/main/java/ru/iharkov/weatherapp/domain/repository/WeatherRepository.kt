package ru.iharkov.weatherapp.domain.repository

import ru.iharkov.weatherapp.domain.model.Weather

interface WeatherRepository {

    suspend fun getWeather() : Weather
}