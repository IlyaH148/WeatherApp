package ru.iharkov.weatherapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.iharkov.weatherapp.R
import ru.iharkov.weatherapp.states.ForecastDay
import ru.iharkov.weatherapp.states.WeatherState
import ru.iharkov.weatherapp.uikitWeatherApp.spacers.WeatherSpacers
import ru.iharkov.weatherapp.uikitWeatherApp.uiElements.card.WeatherCard
import ru.iharkov.weatherapp.uikitWeatherApp.uiElements.toggle.BottomBar
import ru.iharkov.weatherapp.uikitWeatherApp.uiElements.toggle.BottomBarItem


@Composable
fun Forecast(
    onBackClick: () -> Unit,
    screen: Boolean,
) {
    var selectedIndex by remember{ mutableIntStateOf(1) }
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
    Scaffold() { padding: PaddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
            ) {
            val forecastList = listOf(
                ForecastDay(WeatherState.RAINY, "25 сентября", "+31"),
                ForecastDay(WeatherState.CLOUDY, "26 сентября", "+30"),
                ForecastDay(WeatherState.SUN, "27 сентября", "+29")
            )
            LazyColumn(
                modifier = Modifier
                    .padding(padding)
                    .padding(start = 24.dp, end = 24.dp)
                    .weight(1f),
            ) {
                items(forecastList) { forecastDay ->
                    WeatherCard(forecastDay)
                    Spacer(modifier = Modifier.height(WeatherSpacers.spacer20))
                }
            }
            BottomBar(
                items = items,
                selectedIndex = selectedIndex,
                onSelect = { index ->
                    selectedIndex = index

                    if(index == 0){
                        onBackClick()
                    }
                }
            )
        }
    }

}
