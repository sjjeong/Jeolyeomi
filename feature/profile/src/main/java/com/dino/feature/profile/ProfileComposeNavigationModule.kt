package com.dino.feature.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.dino.core.navigation.ProfileComposeNavigation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class ProfileComposeNavigationModule {

    @Provides
    fun provideProfileComposeNavigation(): ProfileComposeNavigation {
        return object : ProfileComposeNavigation {
            @Composable
            override fun Screen() {
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(
                        modifier = Modifier.align(Alignment.Center),
                        text = "Profile Screen"
                    )
                }
            }
        }
    }
}