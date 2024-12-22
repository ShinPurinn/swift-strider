package com.kel2.swiftstrider.ui.common.extension

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.kel2.swiftstrider.ui.nav.BottomNavDestination

fun NavController.navigateToBottomNavDestination(item: BottomNavDestination) {
    navigate(item.route) {
        popUpTo(graph.findStartDestination().id) {
            this.saveState = true
        }
        restoreState = true
        launchSingleTop = true
    }
}