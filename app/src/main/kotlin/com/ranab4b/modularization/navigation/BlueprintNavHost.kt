package com.ranab4b.modularization.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.ranab4b.modularization.feature.detail.DetailScreen
import com.ranab4b.modularization.feature.detail.ITEM_ID_ARG
import com.ranab4b.modularization.feature.home.HomeScreen
import com.ranab4b.modularization.feature.settings.SettingsScreen

private object Routes {
    const val HOME = "home"
    const val SETTINGS = "settings"
    const val DETAIL = "detail/{$ITEM_ID_ARG}"
    fun detail(itemId: String) = "detail/$itemId"
}

/**
 * The only place in the whole app that knows about routes. Feature screens are
 * navigation-agnostic - they only see the lambda callbacks passed in below.
 */
@Composable
fun BlueprintNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.HOME) {
        composable(Routes.HOME) {
            HomeScreen(
                onItemClick = { itemId -> navController.navigate(Routes.detail(itemId)) },
                onSettingsClick = { navController.navigate(Routes.SETTINGS) },
            )
        }
        composable(
            route = Routes.DETAIL,
            arguments = listOf(navArgument(ITEM_ID_ARG) { type = NavType.StringType }),
        ) {
            DetailScreen(onBack = { navController.popBackStack() })
        }
        composable(Routes.SETTINGS) {
            SettingsScreen(onBack = { navController.popBackStack() })
        }
    }
}
