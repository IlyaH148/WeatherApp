package ru.iharkov.weatherapp.presentation.common.mapper

import ru.iharkov.weatherapp.domain.model.Forecast
import ru.iharkov.weatherapp.domain.model.Weather
import ru.iharkov.weatherapp.domain.model.WeatherCondition
import ru.iharkov.weatherapp.presentation.forecast.ForecastDay
import ru.iharkov.weatherapp.presentation.common.states.WeatherState
import ru.iharkov.weatherapp.presentation.currentweather.WeatherUiModel
import java.time.format.DateTimeFormatter
import java.util.Locale


fun mapConditionToUi(condition: WeatherCondition): WeatherState {
    return when (condition) {
        WeatherCondition.SUN -> WeatherState.SUN
        WeatherCondition.CLOUDY -> WeatherState.CLOUDY
        WeatherCondition.RAINY -> WeatherState.RAINY
        WeatherCondition.DEFAULT -> WeatherState.DEFAULT
        WeatherCondition.PARTY_CLOUDY -> WeatherState.PARTY_CLOUDY
        WeatherCondition.HEAVE_SLEET -> WeatherState.HEAVE_SLEET
        WeatherCondition.FOG -> WeatherState.FOG
        WeatherCondition.HEAVE_SLEET_SNOW_SHOWER -> WeatherState.HEAVE_SLEET_SNOW_SHOWER
        WeatherCondition.HEAVE_SNOW -> WeatherState.HEAVE_SNOW
        WeatherCondition.OVERCAST -> WeatherState.OVERCAST
        WeatherCondition.SMALL_RAIN -> WeatherState.SMALL_RAIN
        WeatherCondition.SNOWY -> WeatherState.SNOWY
        WeatherCondition.SNOWY_SHOWER -> WeatherState.SNOWY_SHOWER
        WeatherCondition.THUNDERSTORM_SHOWERS -> WeatherState.THUNDERSTORM_SHOWERS
        WeatherCondition.WINDY -> WeatherState.WINDY
    }
}
fun mapWeatherToUi(weather: Weather): WeatherUiModel {

    val weatherState = mapConditionToUi(weather.weatherCondition)
    return WeatherUiModel(
        temperature = if (weather.temperature > 0) "+${weather.temperature}°" else if (weather.temperature < 0) "${weather.temperature}°" else "0°",
        weatherState = weatherState,
        windSpeed = " ${weather.windSpeed} М/С",
        pressure = " ${weather.pressure} мм.",
        humidity = " ${weather.humidity} %"
    )
}

fun mapForecastToUi(forecast: Forecast): ForecastDay{
    val formatter = DateTimeFormatter.ofPattern("d MMMM", Locale("ru"))
    return ForecastDay(
        weatherState = mapConditionToUi(forecast.weatherCondition),
        date = forecast.date.format(formatter),
        temperature = if(forecast.temperature > 0) "+${forecast.temperature}" else if(forecast.temperature < 0) "${forecast.temperature}" else "0"
        )
}


