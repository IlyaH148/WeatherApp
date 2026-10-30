package ru.iharkov.weatherapp.uikitWeatherApp.uiElements.statistics

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.iharkov.weatherapp.R
import ru.iharkov.weatherapp.uikitWeatherApp.color.WeatherColors
import ru.iharkov.weatherapp.uikitWeatherApp.spacers.WeatherSpacers
import ru.iharkov.weatherapp.uikitWeatherApp.typography.WeatherTypography

@Composable
fun Statistics(
    time: String,
    speedWind: String,
    pressure: String,
    wet: String,
    modifier: Modifier = Modifier
)
{
    val shapeDescription = RoundedCornerShape(WeatherSpacers.spacer12)
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp)
            .clip(shapeDescription)
            .background(WeatherColors.description)
            .padding(start = 15.dp, top = 6.dp, end = 15.dp, bottom = 9.dp )
        ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.time),
            )
            Text(
                text = time,
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.speed_wind)
            )
            Text(
                text = speedWind,
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = stringResource(R.string.pressure)
            )
            Text(
                text = pressure,
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.wet),
                color = WeatherColors.descriptionTitle
            )
            Text(
                text = wet,
                style = WeatherTypography.headlineMedium15,
            )
        }
    }
}