package ru.iharkov.weatherapp.data.repository.mapper

import ru.iharkov.weatherapp.data.repository.remote.dto.CurrentDto
import ru.iharkov.weatherapp.data.repository.remote.dto.DailyDto
import ru.iharkov.weatherapp.domain.model.Forecast
import ru.iharkov.weatherapp.domain.model.Weather
import ru.iharkov.weatherapp.domain.model.WeatherCondition
import java.math.BigDecimal
import java.math.RoundingMode
import java.time.LocalDate
import kotlin.math.roundToInt

fun mapIconToCondition(icon: String): WeatherCondition{
    return when(icon){
        "clear-day","clear-night" -> WeatherCondition.SUN
        "partly-cloudy-day","partly-cloudy-night" -> WeatherCondition.PARTY_CLOUDY
        "cloudy" -> WeatherCondition.CLOUDY
        "fog" -> WeatherCondition.FOG
        "rain" -> WeatherCondition.RAINY
        "snow" -> WeatherCondition.SNOWY
        "snow-showers-day","snow-showers-night" -> WeatherCondition.HEAVE_SNOW
        "showers-day","showers-night" -> WeatherCondition.HEAVE_SLEET
        "thunder-showers-day","thunder-showers-night","thunder-rain" -> WeatherCondition.THUNDERSTORM_SHOWERS
        "wind" -> WeatherCondition.WINDY
        else -> WeatherCondition.DEFAULT
    }
}

fun mapCurrentDtoToWeather(currentDto: CurrentDto): Weather{

    fun Double.roundToOneDecimal() : Double =
        BigDecimal.valueOf(this).setScale(1, RoundingMode.HALF_UP).toDouble()

    val weatherCondition = mapIconToCondition(currentDto.icon)
    return Weather(
        temperature = currentDto.temp.roundToInt(),
        weatherCondition = weatherCondition,
        windSpeed = (currentDto.windspeed/3.6).roundToOneDecimal(),
        pressure = (currentDto.pressure * 0.75006).roundToInt(),
        humidity = currentDto.humidity.roundToInt()
    )
}

fun mapDaysToForecastList(dailyDto: List<DailyDto>): List<Forecast>{
    return dailyDto.map { day ->
        Forecast(
            weatherCondition = mapIconToCondition(day.icon),
            date = LocalDate.parse(day.datetime),
            temperature = day.tempmax.roundToInt()
        )
    }
}