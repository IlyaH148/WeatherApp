package ru.iharkov.weatherapp.screens

import android.service.chooser.AdditionalContentContract
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.iharkov.weatherapp.R
import ru.iharkov.weatherapp.domain.model.Weather
import ru.iharkov.weatherapp.domain.model.WeatherCondition
import ru.iharkov.weatherapp.presentation.currentweather.CurrentWeatherUiState
import ru.iharkov.weatherapp.presentation.currentweather.CurrentWeatherViewModel
import ru.iharkov.weatherapp.states.WeatherState
import ru.iharkov.weatherapp.uikitWeatherApp.uiElements.statistics.TopBar
import ru.iharkov.weatherapp.uikitWeatherApp.uiElements.toggle.BottomBar
import ru.iharkov.weatherapp.uikitWeatherApp.uiElements.toggle.BottomBarItem
import ru.iharkov.weatherapp.uikitWeatherApp.uiElements.weatherInformation.BigWeather

@Composable
fun CurrentWeather(
    onNextClick: () -> Unit,
    screen: Boolean,
    currentWeather: WeatherState = WeatherState.RAINY,
) {
    val viewModel: CurrentWeatherViewModel = viewModel()
    val uiState = viewModel.uiState.collectAsState()

    var selectedIndex by remember { mutableIntStateOf(0) }

    LaunchedEffect(Unit) {
        viewModel.loadWeather()
    }

    val items = listOf(
        BottomBarItem(
            icon = R.drawable.ic_sun_label,
            title = R.string.weather,
        ),
        BottomBarItem(
            icon = R.drawable.ic_time_icon,
            title = R.string.predict,
        )
    )

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->

        when (val state = uiState.value) {

            is CurrentWeatherUiState.Loading -> {
                LoadingScreen()
            }

            is CurrentWeatherUiState.Content -> {
                val weather = state.weather

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    TopBar(
                        "11:25",
                        weather.windSpeed,
                        weather.pressure,
                        weather.humidity,
                    )

                    BigWeather(
                        weather.temperature,
                        weather.weatherState.icon,
                        weather.weatherState.title,
                        modifier = Modifier.padding(
                            start = 42.dp,
                            end = 40.dp
                        )
                    )

                    BottomBar(
                        items = items,
                        selectedIndex = selectedIndex,
                        onSelect = { index ->
                            selectedIndex = index
                            if (index == 1) {
                                onNextClick()
                            }
                        }
                    )
                }
            }

            is CurrentWeatherUiState.Error -> {
                Text(
                    text = state.message,
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}