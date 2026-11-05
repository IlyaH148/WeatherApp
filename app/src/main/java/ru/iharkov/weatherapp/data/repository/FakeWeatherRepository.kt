package ru.iharkov.weatherapp.data.repository

import ru.iharkov.weatherapp.domain.model.Weather
import ru.iharkov.weatherapp.domain.model.WeatherCondition
import ru.iharkov.weatherapp.domain.repository.WeatherRepository

class FakeWeatherRepository() : WeatherRepository{
    override suspend fun getWeather(): Weather{
        val weather = Weather(
            temperature = 31,
            weatherCondition = WeatherCondition.CLOUDY,
            windSpeed = 4.5,
            pressure = 759,
            humidity = 42
        )
        return weather
    }
}