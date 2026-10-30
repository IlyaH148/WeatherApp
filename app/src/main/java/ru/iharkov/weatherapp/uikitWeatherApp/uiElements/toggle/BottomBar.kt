@file:Suppress("PreviewAnnotationInFunctionWithParameters")

package ru.iharkov.weatherapp.uikitWeatherApp.uiElements.toggle

import android.text.Layout
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.composable
import ru.iharkov.weatherapp.R
import ru.iharkov.weatherapp.navigation.Destination
import ru.iharkov.weatherapp.uikitWeatherApp.color.WeatherColors
import ru.iharkov.weatherapp.uikitWeatherApp.typography.WeatherTypography


@Composable
fun BottomBar(
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier,
    screenFirstState: Boolean,
    screenSecondState: Boolean,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = modifier.padding(top = 12.dp, bottom = 16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (screenFirstState) {
                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .clip(RoundedCornerShape(16.dp))
                            .background(WeatherColors.accent70)
                            .size(64.dp, 32.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_sun_label),
                            contentDescription = "",

                            )
                    }
                } else {
                    IconButton(
                        onClick = onNextClick
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_sun_label),
                            contentDescription = "",

                            )
                    }
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = stringResource(R.string.weather),
                    style = if (screenFirstState) {
                        WeatherTypography.labelSemiBold14
                    } else {
                        WeatherTypography.labelMedium12
                    },
                    color = if (screenFirstState) {
                        WeatherColors.labelAccent
                    } else {
                        WeatherColors.label
                    }
                )
            }
        }
        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = modifier.padding(top = 12.dp, bottom = 16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (screenSecondState) {
                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .clip(RoundedCornerShape(16.dp))
                            .background(WeatherColors.accent70)
                            .size(64.dp, 32.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_time_icon),
                            contentDescription = ""
                        )
                    }
                }else{
                    IconButton(
                        onClick = onNextClick,
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_time_icon),
                            contentDescription = ""
                        )
                    }
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    stringResource(R.string.predict),
                    style = if(screenSecondState){
                        WeatherTypography.labelSemiBold14
                    }else{
                        WeatherTypography.labelMedium12
                    },
                    color = if(screenSecondState){
                        WeatherColors.labelAccent
                    }else {
                        WeatherColors.label
                    }
                )
            }

        }

    }

}

