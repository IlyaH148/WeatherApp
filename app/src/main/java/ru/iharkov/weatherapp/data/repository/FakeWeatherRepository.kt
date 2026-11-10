package ru.iharkov.weatherapp.data.repository

import androidx.compose.animation.slideOutHorizontally
import ru.iharkov.weatherapp.domain.model.Forecast
import ru.iharkov.weatherapp.domain.model.Weather
import ru.iharkov.weatherapp.domain.model.WeatherCondition
import ru.iharkov.weatherapp.domain.repository.WeatherRepository
import java.time.LocalDate

class FakeWeatherRepository() : WeatherRepository {
    override suspend fun getWeather(): Weather {
        throw IllegalArgumentException("Ошибка")
        val weather = Weather(
            temperature = 31,
            weatherCondition = WeatherCondition.PARTY_CLOUDY,
            windSpeed = 4.5,
            pressure = 759,
            humidity = 42
        )
        return weather
    }

    override suspend fun getForecast(): List<Forecast> {
        return listOf(
            Forecast(
                weatherCondition = WeatherCondition.CLOUDY,
                date = LocalDate.of(2026, 9, 27),
                temperature = 17,
            ),
            Forecast(
                weatherCondition = WeatherCondition.SUN,
                date = LocalDate.of(2026, 9, 28),
                temperature = 20
            ),
            Forecast(
                weatherCondition = WeatherCondition.CLOUDY,
                date = LocalDate.of(2026, 9, 29),
                temperature = 12
            ),
            Forecast(
                weatherCondition = WeatherCondition.CLOUDY,
                date = LocalDate.of(2026, 9, 30),
                temperature = 11
            ),
            Forecast(
                weatherCondition = WeatherCondition.CLOUDY,
                date = LocalDate.of(2026, 10, 1),
                temperature = 10
            ),
            Forecast(
                weatherCondition = WeatherCondition.CLOUDY,
                date = LocalDate.of(2026, 10, 2),
                temperature = 8
            ),
            Forecast(
                weatherCondition = WeatherCondition.CLOUDY,
                date = LocalDate.of(2026, 10, 3),
                temperature = 11
            ),
            Forecast(
                weatherCondition = WeatherCondition.CLOUDY,
                date = LocalDate.of(2026, 10, 4),
                temperature = 13
            ),
            Forecast(
                weatherCondition = WeatherCondition.CLOUDY,
                date = LocalDate.of(2026, 10, 5),
                temperature = 14
            ),
            Forecast(
                weatherCondition = WeatherCondition.CLOUDY,
                date = LocalDate.of(2026, 10, 6),
                temperature = 10
            )
        )
    }
}