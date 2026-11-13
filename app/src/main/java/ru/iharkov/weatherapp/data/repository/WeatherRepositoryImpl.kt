package ru.iharkov.weatherapp.data.repository

import NoInternetException
import okio.IOException
import retrofit2.HttpException
import ru.iharkov.weatherapp.data.repository.mapper.mapCurrentDtoToWeather
import ru.iharkov.weatherapp.data.repository.mapper.mapDaysToForecastList
import ru.iharkov.weatherapp.data.repository.remote.API_KEY
import ru.iharkov.weatherapp.data.repository.remote.WeatherApi
import ru.iharkov.weatherapp.data.repository.remote.dto.WeatherResponseDto
import ru.iharkov.weatherapp.domain.exception.ServerException
import ru.iharkov.weatherapp.domain.model.Forecast
import ru.iharkov.weatherapp.domain.model.Weather
import ru.iharkov.weatherapp.domain.repository.WeatherRepository

const val LATITUDE = 53.53
const val LONGITUDE = 49.35

class WeatherRepositoryImpl(
    private val api: WeatherApi
): WeatherRepository {

    private suspend fun fetchWeatherResponse(): WeatherResponseDto{
        try {
            return api.getForecast(LATITUDE, LONGITUDE, API_KEY)
        } catch (e: IOException){
            throw NoInternetException()
        }catch (e: HttpException){
            throw ServerException(e.code())
        }
    }
    override suspend fun getWeather(): Weather {
        val response = fetchWeatherResponse()
        return mapCurrentDtoToWeather(response.currentConditions)
    }
    override suspend fun getForecast(): List<Forecast> {
        val response = fetchWeatherResponse()
        return mapDaysToForecastList(response.days)
    }
}