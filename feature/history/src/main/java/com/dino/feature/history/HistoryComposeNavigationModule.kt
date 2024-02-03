package com.dino.feature.history

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.dino.core.navigation.HistoryComposeNavigation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class HistoryComposeNavigationModule {

    @Provides
    fun provideHistoryComposeNavigation(): HistoryComposeNavigation {
        return object : HistoryComposeNavigation {
            @Composable
            override fun Screen() {
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(
                        modifier = Modifier.align(Alignment.Center),
                        text = "History Screen"
                    )
                }
            }
        }
    }
}