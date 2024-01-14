package com.dino.feature.signin

import androidx.compose.runtime.Composable
import com.dino.core.ui.base.BaseActivity

class SignInActivity : BaseActivity() {
    override val content: @Composable () -> Unit = { SignInScreen() }
}