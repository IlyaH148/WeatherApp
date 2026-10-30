package ru.iharkov.weatherapp.uikitWeatherApp.uiElements.error
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
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
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                contentDescription = "",
                painter = painterResource(R.drawable.ic_error),
                modifier = Modifier.size(128.dp ,128.dp)
            )
            Spacer(modifier = Modifier.height(WeatherSpacers.spacer22))
            Text(
                text = "Ошибка",
                textAlign = TextAlign.Center ,
                style = WeatherTypography.errorSemiBold30,
                color = WeatherColors.errorTitle,
            )
            Spacer(modifier = Modifier.height(WeatherSpacers.spacer22))
            Text(
                text = "retrofit.NetworkException: host http://weather.com/ could not be resolved",
                textAlign = TextAlign.Center,
                modifier = Modifier.size(255.dp, 91.dp),
                style = WeatherTypography.errorMedium16,
                color = WeatherColors.errorTitle,
            )
        }
    }
}