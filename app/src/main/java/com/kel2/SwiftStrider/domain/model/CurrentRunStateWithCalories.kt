package com.kel2.SwiftStrider.domain.model

import com.kel2.SwiftStrider.domain.tracking.model.CurrentRunState

data class CurrentRunStateWithCalories(
    val currentRunState: CurrentRunState = CurrentRunState(),
    val caloriesBurnt: Int = 0
)