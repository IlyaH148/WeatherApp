package ru.iharkov.weatherapp.data.repository.mapper

import ru.iharkov.weatherapp.data.repository.remote.dto.CurrentDto
import ru.iharkov.weatherapp.data.repository.remote.dto.DailyDto
import ru.iharkov.weatherapp.domain.model.Forecast
import ru.iharkov.weatherapp.domain.model.Weather
import ru.iharkov.weatherapp.domain.model.WeatherCondition
import ru.iharkov.weatherapp.presentation.common.states.WeatherState
import java.math.BigDecimal
import java.math.RoundingMode
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale
import kotlin.math.roundToInt

fun mapWeatherCodeToCondition(weatherCode: Int): WeatherCondition{
    return when(weatherCode){
        0 -> WeatherCondition.SUN
        1 -> WeatherCondition.PARTY_CLOUDY
        2 -> WeatherCondition.CLOUDY
        3 -> WeatherCondition.OVERCAST
        45,48 -> WeatherCondition.FOG
        51,53,55 -> WeatherCondition.SMALL_RAIN
        56,57 -> WeatherCondition.SNOWY_SHOWER
        61,63,65,80,81,82 -> WeatherCondition.RAINY
        66,67 -> WeatherCondition.SNOWY_SHOWER
        71,73,75 -> WeatherCondition.SNOWY
        77 -> WeatherCondition.HEAVE_SNOW
        85,86 -> WeatherCondition.HEAVE_SLEET_SNOW_SHOWER
        95,96,99 -> WeatherCondition.THUNDERSTORM_SHOWERS
        else -> WeatherCondition.DEFAULT
    }
}

fun mapCurrentDtoToWeather(currentDto: CurrentDto): Weather{

    fun Double.roundToOneDecimal() : Double =
        BigDecimal.valueOf(this).setScale(1, RoundingMode.HALF_UP).toDouble()

    val weatherCondition = mapWeatherCodeToCondition(currentDto.weather_code)
    return Weather(
        temperature = currentDto.temperature_2m.roundToInt(),
        weatherCondition = weatherCondition,
        windSpeed = currentDto.wind_speed_10m.roundToOneDecimal(),
        pressure = (currentDto.surface_pressure * 0.75006).roundToInt(),
        humidity = currentDto.relative_humidity_2m
    )
}

fun mapDailyDtoToForecastList(dailyDto: DailyDto): List<Forecast>{
    return dailyDto.time.indices.map { i ->
        Forecast(
            weatherCondition = mapWeatherCodeToCondition(dailyDto.weather_code[i]),
            date = LocalDate.parse(dailyDto.time[i]),
            temperature = dailyDto.temperature_2m_max[i].roundToInt()
        )
    }
}