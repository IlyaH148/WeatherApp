package ru.iharkov.weatherapp.uikitWeatherApp.uiElements.error
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.iharkov.weatherapp.R
import ru.iharkov.weatherapp.uikitWeatherApp.color.WeatherColors
import ru.iharkov.weatherapp.uikitWeatherApp.spacers.WeatherSpacers
import ru.iharkov.weatherapp.uikitWeatherApp.typography.WeatherTypography


@Composable
fun ErrorScreen(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(start = 60.dp, end = 60.dp)
        ) {
            Image(
                contentDescription = "",
                painter = painterResource(R.drawable.ic_error),
            )
            Spacer(modifier = Modifier.height(WeatherSpacers.spacer22))
            Text(
                text = stringResource(R.string.error),
                textAlign = TextAlign.Center ,
                style = WeatherTypography.errorSemiBold30,
                color = WeatherColors.errorTitle,
            )
            Spacer(modifier = Modifier.height(WeatherSpacers.spacer22))
            Text(
                text = stringResource(R.string.error_description),
                textAlign = TextAlign.Center,
                style = WeatherTypography.errorMedium16,
                color = WeatherColors.errorTitle,
            )
        }
    }
}