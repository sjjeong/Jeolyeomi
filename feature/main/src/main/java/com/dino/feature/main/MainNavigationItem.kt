package com.dino.feature.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.vector.ImageVector

enum class MainNavigationItem(
    val route: String,
    val icon: ImageVector,
    val title: String,
) {

    HOME(
        route = "home",
        icon = Icons.Default.Home,
        title = "Home",
    ),
    HISTORY(
        route = "history",
        icon = Icons.Default.List,
        title = "History",
    ),
    PROFILE(
        route = "profile",
        icon = Icons.Default.Info,
        title = "Profile",
    ),

}