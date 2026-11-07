package ru.iharkov.weatherapp.uikitWeatherApp.uiElements.statistics

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
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
fun TopBar(
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
    ) {
        val titleList = listOf(R.string.time, R.string.speed_wind, R.string.pressure, R.string.wet)
        val valueList = listOf(time, speedWind, pressure, wet)
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            itemsIndexed(titleList){ index, item ->
                TopBarItem(
                    title = stringResource(item) ,
                    value = valueList[index]
                )
            }
        }
    }
}
@Composable
fun TopBarItem(
    title: String,
    value: String,
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = title,
            style = WeatherTypography.headlineSemiBold12,
            color = WeatherColors.descriptionTitle)
        Text(text = value,
            style = WeatherTypography.headlineMedium15,
            color = WeatherColors.black)
    }

}