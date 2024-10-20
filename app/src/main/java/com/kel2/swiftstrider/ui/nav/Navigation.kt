package com.kel2.swiftstrider.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kel2.swiftstrider.ui.nav.Destination.CurrentRun
import com.kel2.swiftstrider.ui.screen.currentrun.CurrentRunScreen
import com.kel2.swiftstrider.ui.screen.onboard.OnBoardScreen
import com.kel2.swiftstrider.ui.screen.profile.ProfileScreen
import com.kel2.swiftstrider.ui.screen.runstats.RunStatsScreen

@Composable
fun Navigation(
    navController: NavHostController,
) {
    SetupNavGraph(
        navController = navController,
    )
}

@Composable
private fun SetupNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavDestination.Home.route
    ) {
        homeNavigation(navController)

        composable(
            route = BottomNavDestination.Profile.route
        ) {
            ProfileScreen()
        }

        composable(
            route = CurrentRun.route,
            deepLinks = CurrentRun.deepLinks
        ) {
            CurrentRunScreen(navController)
        }

        composable(
            route = Destination.OnBoardingDestination.route
        ) {
            OnBoardScreen(navController = navController)
        }

        composable(route = Destination.RunStats.route) {
            RunStatsScreen(
                navigateUp = { navController.navigateUp() }
            )
        }
    }

}