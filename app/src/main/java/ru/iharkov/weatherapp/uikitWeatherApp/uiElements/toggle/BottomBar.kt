@file:Suppress("PreviewAnnotationInFunctionWithParameters")

package ru.iharkov.weatherapp.uikitWeatherApp.uiElements.toggle


import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.iharkov.weatherapp.R
import ru.iharkov.weatherapp.uikitWeatherApp.color.WeatherColors
import ru.iharkov.weatherapp.uikitWeatherApp.spacers.WeatherSpacers
import ru.iharkov.weatherapp.uikitWeatherApp.typography.WeatherTypography
import kotlin.collections.listOf


@Composable
fun BottomBar(
    items: List<BottomBarItem>,
    selectedIndex: Int,
    onSelect: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {


    LazyRow(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        itemsIndexed(items) { index, item ->
            val isSelected = index == selectedIndex
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(top = 12.dp, bottom = 16.dp)
            ) {
                    IconButton(
                        onClick = { onSelect(index) },
                        modifier = Modifier
                            .clip(RoundedCornerShape(16.dp))
                            .size(64.dp,32.dp)
                            .background(if (isSelected) WeatherColors.accent70
                                                else Color.Transparent )
                    ) {
                        Icon(
                            contentDescription = "",
                            painter = painterResource(item.icon),
                            modifier = Modifier
                        )
                    }
                Spacer(modifier = Modifier.height(WeatherSpacers.spacer12))
                Text(
                    text = stringResource(item.title),
                    style = if (isSelected) {
                        WeatherTypography.labelSemiBold14
                    } else {
                        WeatherTypography.labelMedium12
                    },
                    color = if (isSelected) {
                        WeatherColors.labelAccent
                    } else {
                        WeatherColors.label
                    }
                )
            }
        }
    }
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

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun BottomBarPrev() {
    BottomBar(
        items = items,
        selectedIndex = 0,
        onSelect = {},
        modifier = Modifier,
    )
}