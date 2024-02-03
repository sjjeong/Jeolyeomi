package com.dino.feature.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dino.feature.main.compose.BottomNavigationBar

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = viewModel(),
    HomeScreen: @Composable () -> Unit,
    HistoryScreen: @Composable () -> Unit,
    ProfileScreen: @Composable () -> Unit,
) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomAppBar {
                BottomNavigationBar {
                    navController.navigate(it.route) {
                        popUpTo(0)
                    }
                }
            }
        },
        floatingActionButton = {

        }
    ) { paddingValues ->
        Box(
            modifier = Modifier.padding(
                PaddingValues(
                    start = 0.dp,
                    end = 0.dp,
                    top = 0.dp,
                    bottom = paddingValues.calculateBottomPadding(),
                )
            )
        ) {
            NavHost(
                navController = navController,
                startDestination = MainNavigationItem.HOME.route
            ) {
                MainNavigationItem.entries
                    .forEach { mainNavigationItem ->
                        composable(mainNavigationItem.route) {
                            when (mainNavigationItem) {
                                MainNavigationItem.HOME -> HomeScreen()
                                MainNavigationItem.HISTORY -> HistoryScreen()
                                MainNavigationItem.PROFILE -> ProfileScreen()
                            }
                        }
                    }
            }
        }
    }
}