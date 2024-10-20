package com.kel2.swiftstrider.ui.screen.home

import com.kel2.swiftstrider.data.model.Run
import com.kel2.swiftstrider.data.model.User
import com.kel2.swiftstrider.domain.model.CurrentRunStateWithCalories

data class HomeScreenState(
    val runList: List<Run> = emptyList(),
    val currentRunStateWithCalories: CurrentRunStateWithCalories = CurrentRunStateWithCalories(),
    val currentRunInfo: Run? = null,
    val user: User = User(),
    val distanceCoveredInKmInThisWeek: Float = 0.0f
)
