package ru.iharkov.weatherapp.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.iharkov.weatherapp.R
import ru.iharkov.weatherapp.States.WeatherState
import ru.iharkov.weatherapp.navigation.AppNavHost
import ru.iharkov.weatherapp.ui.theme.WeatherAppTheme
import ru.iharkov.weatherapp.uikitWeatherApp.uiElements.card.WeatherCard
import ru.iharkov.weatherapp.uikitWeatherApp.uiElements.statistics.Statistics
import ru.iharkov.weatherapp.uikitWeatherApp.uiElements.toggle.BottomBar
import ru.iharkov.weatherapp.uikitWeatherApp.uiElements.weatherInformation.BigWeather

@Composable
fun CurrentWeather(
    onNextClick: () -> Unit,
    screen: Boolean,
    currentWeather: WeatherState = WeatherState.DEFAULT,
) {
    WeatherAppTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Statistics(
                    "11:25",
                    "4.5 М/c",
                    "759 мм.",
                    "42 %",
                    modifier = Modifier.padding(innerPadding)
                )
                BigWeather(
                    "+31", currentWeather.icon, currentWeather.title,
                    modifier = Modifier.padding(start = 42.dp, end = 40.dp)
                )
                BottomBar(onNextClick = onNextClick,
                    screenFirstState = screen,
                    screenSecondState = false)
                }
            }
        }
    }