package com.dino.feature.main.compose

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.dino.feature.main.MainNavigationItem

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    onNavigationClick: (MainNavigationItem) -> Unit,
) {
    val items = MainNavigationItem.entries

    var selected by remember { mutableStateOf(0) }

    NavigationBar(modifier = modifier) {
        items.forEachIndexed { index, mainNavigationItem ->
            NavigationBarItem(
                selected = selected == index,
                onClick = {
                    selected = index
                    onNavigationClick(mainNavigationItem)
                },
                icon = {
                    Icon(
                        imageVector = mainNavigationItem.icon,
                        contentDescription = mainNavigationItem.title,
                    )
                },
                label = {
                    Text(text = mainNavigationItem.title)
                },
                alwaysShowLabel = true,
            )
        }
    }
}