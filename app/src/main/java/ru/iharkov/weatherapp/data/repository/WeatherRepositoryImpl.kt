package ru.iharkov.weatherapp.data.repository

import NoInternetException
import android.util.Log
import okio.IOException
import retrofit2.HttpException
import ru.iharkov.weatherapp.data.repository.local.WeatherDao
import ru.iharkov.weatherapp.data.repository.mapper.mapCurrentDtoToWeather

import ru.iharkov.weatherapp.data.repository.mapper.mapDaysToForecastList
import ru.iharkov.weatherapp.data.repository.mapper.mapForecastEntityToForecast
import ru.iharkov.weatherapp.data.repository.mapper.mapForecastToForecastEntity
import ru.iharkov.weatherapp.data.repository.mapper.mapWeatherEntityToWeather
import ru.iharkov.weatherapp.data.repository.mapper.mapWeatherToWeatherEntity
import ru.iharkov.weatherapp.data.repository.remote.API_KEY
import ru.iharkov.weatherapp.data.repository.remote.WeatherApi
import ru.iharkov.weatherapp.data.repository.remote.dto.WeatherResponseDto
import ru.iharkov.weatherapp.domain.exception.ServerException
import ru.iharkov.weatherapp.domain.model.Forecast
import ru.iharkov.weatherapp.domain.model.Weather
import ru.iharkov.weatherapp.domain.model.WeatherCondition
import ru.iharkov.weatherapp.domain.repository.WeatherRepository
import java.time.LocalTime

const val LATITUDE = 53.53
const val LONGITUDE = 49.35

const val CACHE_TTL_MS = 10 * 60 * 1000L

class WeatherRepositoryImpl(
    private val api: WeatherApi,
    private val dao: WeatherDao
) : WeatherRepository {

    private suspend fun fetchWeatherResponse(): WeatherResponseDto {
        try {
            return api.getForecast(LATITUDE, LONGITUDE, API_KEY)
        } catch (e: IOException) {
            throw NoInternetException()
        } catch (e: HttpException) {
            throw ServerException(e.code())
        }
    }

    override suspend fun getWeather(): Weather {
        val cached = dao.getWeather()
        val now = System.currentTimeMillis()
        if (cached != null && (now - cached.savedAt) < CACHE_TTL_MS) {
            Log.d("!!!", "getWeather: отработало в ветке кэша ")
            return mapWeatherEntityToWeather(cached)

        } else {
            Log.d("!!!", "getWeather: отработало в ветке сети ")
            val response = fetchWeatherResponse()
            val weather = mapCurrentDtoToWeather(response.currentConditions)
            dao.insertWeather(mapWeatherToWeatherEntity(weather, now))
            return weather
        }
    }

    override suspend fun getForecast(): List<Forecast> {
        val cached = dao.getForecast()
        val now = System.currentTimeMillis()
        if (cached.isNotEmpty() && now - cached.first().savedAt < CACHE_TTL_MS) {
            Log.d("!!!", "getForecast: отработало в ветке кэша ")
            return cached.map { entity ->
                mapForecastEntityToForecast(entity)
            }
        } else {
            Log.d("!!!", "getForecast: отработало в ветке сети ")
            val response = fetchWeatherResponse()
            val forecast = mapDaysToForecastList(response.days)
            dao.clear()
            dao.insertForecast(forecast.map { mapForecastToForecastEntity(it, now) })
            return forecast
        }
    }
}