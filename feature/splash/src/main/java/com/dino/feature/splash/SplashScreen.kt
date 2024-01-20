package com.dino.feature.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SplashScreen(
) {
    Scaffold { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues))

    }

}