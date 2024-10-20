package com.kel2.SwiftStrider.ui.screen.home

import com.kel2.SwiftStrider.data.model.Run
import com.kel2.SwiftStrider.data.model.User
import com.kel2.SwiftStrider.domain.model.CurrentRunStateWithCalories

data class HomeScreenState(
    val runList: List<Run> = emptyList(),
    val currentRunStateWithCalories: CurrentRunStateWithCalories = CurrentRunStateWithCalories(),
    val currentRunInfo: Run? = null,
    val user: User = User(),
    val distanceCoveredInKmInThisWeek: Float = 0.0f
)
