package com.kel2.swiftstrider.ui.screen.currentrun

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kel2.swiftstrider.data.model.Run
import com.kel2.swiftstrider.data.repository.AppRepository
import com.kel2.swiftstrider.di.ApplicationScope
import com.kel2.swiftstrider.di.IoDispatcher
import com.kel2.swiftstrider.domain.model.CurrentRunStateWithCalories
import com.kel2.swiftstrider.domain.tracking.TrackingManager
import com.kel2.swiftstrider.domain.usecase.GetCurrentRunStateWithCaloriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.math.RoundingMode
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class CurrentRunViewModel @Inject constructor(
    private val trackingManager: TrackingManager,
    private val repository: AppRepository,
    @ApplicationScope
    private val appCoroutineScope: CoroutineScope,
    @IoDispatcher
    private val ioDispatcher: CoroutineDispatcher,
    getCurrentRunStateWithCaloriesUseCase: GetCurrentRunStateWithCaloriesUseCase
) : ViewModel() {
    val currentRunStateWithCalories = getCurrentRunStateWithCaloriesUseCase()
        .stateIn(
            viewModelScope,
            SharingStarted.Lazily,
            CurrentRunStateWithCalories()
        )
    val runningDurationInMillis = trackingManager.trackingDurationInMs

    fun playPauseTracking() {
        if (currentRunStateWithCalories.value.currentRunState.isTracking)
            trackingManager.pauseTracking()
        else trackingManager.startResumeTracking()
    }

    fun finishRun(bitmap: Bitmap) {
        trackingManager.pauseTracking()
        saveRun(
            Run(
                img = bitmap,
                avgSpeedInKMH = currentRunStateWithCalories.value.currentRunState.distanceInMeters
                    .toBigDecimal()
                    .multiply(3600.toBigDecimal())
                    .divide(runningDurationInMillis.value.toBigDecimal(), 2, RoundingMode.HALF_UP)
                    .toFloat(),
                distanceInMeters = currentRunStateWithCalories.value.currentRunState.distanceInMeters,
                durationInMillis = runningDurationInMillis.value,
                timestamp = Date(),
                caloriesBurned = currentRunStateWithCalories.value.caloriesBurnt
            )
        )
        trackingManager.stop()
    }

    private fun saveRun(run: Run) = appCoroutineScope.launch(ioDispatcher) {
        repository.insertRun(run)
    }

}