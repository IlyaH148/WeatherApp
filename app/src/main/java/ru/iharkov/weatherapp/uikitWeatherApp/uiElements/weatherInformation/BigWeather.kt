package ru.iharkov.weatherapp.uikitWeatherApp.uiElements.weatherInformation

import android.graphics.Paint
import android.media.Image
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.iharkov.weatherapp.R
import ru.iharkov.weatherapp.uikitWeatherApp.color.WeatherColors
import ru.iharkov.weatherapp.uikitWeatherApp.spacers.WeatherSpacers
import ru.iharkov.weatherapp.uikitWeatherApp.typography.WeatherTypography


@Composable
fun BigWeather(
    temperature: String,
    @DrawableRes weather: Int,
    @StringRes title: Int,
    modifier: Modifier = Modifier
) {
    val circleClip = RoundedCornerShape(500.dp)

    BoxWithConstraints(
        modifier = modifier,

        ) {
        val circleSize = minOf(maxWidth,maxHeight)
        Box(
            modifier = Modifier
                .size(circleSize)
                .background(WeatherColors.accent70, CircleShape),

            contentAlignment = Alignment.Center,

            ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    contentDescription = "",
                    painter = painterResource(id = weather),
                    modifier = Modifier.size(106.dp, 96.dp)
                )
                Spacer(modifier = Modifier.height(WeatherSpacers.spacer26))
                Text(
                    text = stringResource(title),
                    style = WeatherTypography.titleSemiBold30,
                    color = WeatherColors.white
                )
                Spacer(modifier = Modifier.height(WeatherSpacers.spacer16))
                Text(
                    text = "$temperature°",
                    style = WeatherTypography.titleMedium70,
                    color = WeatherColors.white
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun BigWeatherPrev(
){
    BigWeather(
        "+31",R.drawable.ic_heave_snow, R.string.weather_rainy
    )
}