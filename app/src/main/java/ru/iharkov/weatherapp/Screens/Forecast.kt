package ru.iharkov.weatherapp.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.iharkov.weatherapp.R
import ru.iharkov.weatherapp.States.ForecastDay
import ru.iharkov.weatherapp.States.WeatherState
import ru.iharkov.weatherapp.uikitWeatherApp.spacers.WeatherSpacers
import ru.iharkov.weatherapp.uikitWeatherApp.uiElements.card.WeatherCard

import ru.iharkov.weatherapp.uikitWeatherApp.uiElements.toggle.BottomBar


@Composable
fun Forecast(
    onBackClick: () -> Unit,
    screen: Boolean,
    ) {
    Column(
        modifier = Modifier.fillMaxSize(),

        ) {
        val forecastList = listOf(
            ForecastDay(WeatherState.RAINY, "25 сентября", "+31"),
            ForecastDay(WeatherState.CLOUDY, "26 сентября", "+30"),
            ForecastDay(WeatherState.SUN, "27 сентября", "+29"))
        LazyColumn(
            modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 55.dp).weight(1f)
        ) {
            items(forecastList){ forecastDay ->
                WeatherCard(forecastDay)
                Spacer(modifier = Modifier.height(WeatherSpacers.spacer20))
            }
        }
            BottomBar(
                onNextClick = onBackClick,
                screenFirstState  = false,
                screenSecondState = screen
            )

    }
}
