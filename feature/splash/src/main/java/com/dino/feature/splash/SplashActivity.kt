package com.dino.feature.splash

import android.content.Intent
import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.core.net.toUri
import com.dino.core.ui.base.BaseActivity

class SplashActivity : BaseActivity() {
    override val content: @Composable () -> Unit = {
        SplashScreen()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(Intent.ACTION_VIEW, "jeolyeomi://signin".toUri()))
    }
}