package ru.iharkov.weatherapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.iharkov.weatherapp.R
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
    var selectedIndex by remember{ mutableIntStateOf(0) }

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
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                TopBar(
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
                BottomBar(items = items,
                    selectedIndex = selectedIndex,
                    onSelect = {index ->
                        selectedIndex = index

                        if(index == 1){
                            onNextClick()
                        }
                    })
                }
            }
    }