package ru.iharkov.weatherapp.presentation.currentweather

import ru.iharkov.weatherapp.domain.model.Weather
import ru.iharkov.weatherapp.domain.model.WeatherCondition
import ru.iharkov.weatherapp.states.WeatherState

fun mapWeatherToUi(weather: Weather): WeatherUiModel{

    val weatherState = when(weather.weatherCondition){
        WeatherCondition.SUN -> WeatherState.SUN
        WeatherCondition.RAINY -> WeatherState.RAINY
        WeatherCondition.CLOUDY -> WeatherState.CLOUDY
        WeatherCondition.DEFAULT -> WeatherState.DEFAULT
    }
    return WeatherUiModel(
        temperature = " ${weather.temperature}°",
        weatherState = weatherState,
        windSpeed = " ${weather.windSpeed} м/с",
        pressure = " ${weather.pressure} мм",
        humidity = " ${weather.humidity} %"
    )
}