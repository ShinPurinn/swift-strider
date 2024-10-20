package com.kel2.SwiftStrider.ui.screen.profile

import com.kel2.SwiftStrider.data.model.User

data class ProfileScreenState(
    val totalDistanceInKm: Float = 0f,
    val totalDurationInHr: Float = 0f,
    val totalCaloriesBurnt: Long = 0,
    val user: User = User(),
    val isEditMode: Boolean = false,
    val errorMsg: String? = null
)
