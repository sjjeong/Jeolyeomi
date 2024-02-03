package com.dino.feature.profile

import android.content.Intent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.net.toUri
import com.dino.core.navigation.ProfileComposeNavigation
import com.kakao.sdk.user.UserApiClient
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
                val context = LocalContext.current
                Box(modifier = Modifier.fillMaxSize()) {
                    Column(
                        modifier = Modifier.align(Alignment.Center),
                    ) {
                        Text(
                            text = "Profile Screen"
                        )
                        Button(onClick = {
                            UserApiClient.instance.logout { error ->
                                if (error != null) {
                                    // 로그아웃 실패
                                } else {
                                    // 로그아웃 성공
                                    context.startActivity(Intent(Intent.ACTION_VIEW, "jeolyeomi://splash".toUri()).apply {
                                        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                    })
                                }
                            }
                        }) {
                            Text(text = "로그아웃")
                        }
                    }
                }
            }
        }
    }
}