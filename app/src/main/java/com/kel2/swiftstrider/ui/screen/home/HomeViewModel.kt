package com.kel2.swiftstrider.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kel2.swiftstrider.common.extension.setDateToWeekFirstDay
import com.kel2.swiftstrider.common.extension.setDateToWeekLastDay
import com.kel2.swiftstrider.data.model.Run
import com.kel2.swiftstrider.data.repository.AppRepository
import com.kel2.swiftstrider.data.repository.UserRepository
import com.kel2.swiftstrider.di.ApplicationScope
import com.kel2.swiftstrider.di.IoDispatcher
import com.kel2.swiftstrider.domain.tracking.TrackingManager
import com.kel2.swiftstrider.domain.usecase.GetCurrentRunStateWithCaloriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: AppRepository,
    trackingManager: TrackingManager,
    @ApplicationScope
    private val externalScope: CoroutineScope,
    @IoDispatcher
    private val ioDispatcher: CoroutineDispatcher,
    userRepository: UserRepository,
    getCurrentRunStateWithCaloriesUseCase: GetCurrentRunStateWithCaloriesUseCase
) : ViewModel() {

    val durationInMillis = trackingManager.trackingDurationInMs

    val doesUserExist = userRepository.doesUserExist
        .stateIn(
            viewModelScope,
            SharingStarted.Lazily,
            null
        )

    private val calendar = Calendar.getInstance()

    private val distanceCoveredInThisWeekInMeter = repository.getTotalDistance(
        calendar.setDateToWeekFirstDay().time,
        calendar.setDateToWeekLastDay().time
    )

    private val _homeScreenState = MutableStateFlow(HomeScreenState())
    val homeScreenState = combine(
        repository.getRunByDescDateWithLimit(3),
        getCurrentRunStateWithCaloriesUseCase(),
        userRepository.user,
        distanceCoveredInThisWeekInMeter,
        _homeScreenState,
    ) { runList, runState, user, distanceInMeter, state ->
        state.copy(
            runList = runList,
            currentRunStateWithCalories = runState,
            user = user,
            distanceCoveredInKmInThisWeek = distanceInMeter / 1000f
        )
    }.stateIn(
        viewModelScope,
        SharingStarted.Lazily,
        HomeScreenState()
    )

    fun deleteRun(run: Run) = externalScope.launch(ioDispatcher) {
        dismissRunDialog()
        repository.deleteRun(run)
    }

    fun showRun(run: Run) {
        _homeScreenState.update { it.copy(currentRunInfo = run) }
    }

    fun dismissRunDialog() {
        _homeScreenState.update { it.copy(currentRunInfo = null) }
    }

}