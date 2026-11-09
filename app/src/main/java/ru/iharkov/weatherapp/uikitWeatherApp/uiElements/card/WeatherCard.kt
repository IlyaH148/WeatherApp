package ru.iharkov.weatherapp.uikitWeatherApp.uiElements.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.iharkov.weatherapp.presentation.currentweather.states.ForecastDay
import ru.iharkov.weatherapp.uikitWeatherApp.color.WeatherColors
import ru.iharkov.weatherapp.uikitWeatherApp.typography.WeatherTypography


@Composable
fun WeatherCard(
    forecast: ForecastDay,
) {

    val cardShape = RoundedCornerShape(10.dp)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(cardShape)
            .background(WeatherColors.accent),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {

        Text(
            text = forecast.date,
            modifier = Modifier.padding(start = 7.dp),
            style = WeatherTypography.captionSemiBold14,
            color = WeatherColors.white
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(top = 10.dp, end = 17.dp, bottom = 10.dp)
        ) {
            Text(
                text = "${forecast.temperature}C°",
                style = WeatherTypography.captionSemiBold20,
                color = WeatherColors.white
            )
            Spacer(modifier = Modifier.width(26.dp))
            Image(
                modifier = Modifier.size(47.25.dp, 29.dp),
                painter = painterResource(id = forecast.weatherState.icon),
                contentDescription = "",

                )
        }

    }

}
