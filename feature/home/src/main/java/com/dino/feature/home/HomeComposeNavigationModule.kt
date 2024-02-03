package com.dino.feature.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.dino.core.navigation.HomeComposeNavigation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class HomeComposeNavigationModule {

    @Provides
    fun provideHomeComposeNavigation(): HomeComposeNavigation {
        return object : HomeComposeNavigation {
            @Composable
            override fun Screen() {
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(
                        modifier = Modifier.align(Alignment.Center),
                        text = "Home Screen"
                    )
                }
            }
        }
    }
}