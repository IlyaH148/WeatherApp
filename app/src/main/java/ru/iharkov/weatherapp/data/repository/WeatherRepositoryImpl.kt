package ru.iharkov.weatherapp.data.repository

import ru.iharkov.weatherapp.data.repository.mapper.mapCurrentDtoToWeather
import ru.iharkov.weatherapp.data.repository.mapper.mapDaysToForecastList
import ru.iharkov.weatherapp.data.repository.remote.API_KEY
import ru.iharkov.weatherapp.data.repository.remote.WeatherApi
import ru.iharkov.weatherapp.domain.model.Forecast
import ru.iharkov.weatherapp.domain.model.Weather
import ru.iharkov.weatherapp.domain.repository.WeatherRepository

const val LATITUDE = 53.53
const val LONGITUDE = 49.35

class WeatherRepositoryImpl(
    private val api: WeatherApi
): WeatherRepository {
    override suspend fun getWeather(): Weather {
        val response = api.getForecast(LATITUDE, LONGITUDE, API_KEY)
        return mapCurrentDtoToWeather(response.currentConditions)
    }

    override suspend fun getForecast(): List<Forecast> {
        val response = api.getForecast(LATITUDE, LONGITUDE, API_KEY)
        return mapDaysToForecastList(response.days)
    }
}