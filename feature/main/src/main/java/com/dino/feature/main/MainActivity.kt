package com.dino.feature.main

import androidx.compose.runtime.Composable
import com.dino.core.navigation.HistoryComposeNavigation
import com.dino.core.navigation.HomeComposeNavigation
import com.dino.core.navigation.ProfileComposeNavigation
import com.dino.core.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    override val content: @Composable () -> Unit = {
        MainScreen(
            HomeScreen = { homeComposeNavigation.Screen() },
            HistoryScreen = { historyComposeNavigation.Screen() },
            ProfileScreen = { profileComposeNavigation.Screen() }
        )
    }

    @Inject
    lateinit var homeComposeNavigation: HomeComposeNavigation

    @Inject
    lateinit var historyComposeNavigation: HistoryComposeNavigation

    @Inject
    lateinit var profileComposeNavigation: ProfileComposeNavigation

}