package com.kel2.swiftstrider.ui.screen.runstats

import androidx.compose.runtime.Immutable
import com.kel2.swiftstrider.common.extension.setDateToWeekFirstDay
import com.kel2.swiftstrider.common.extension.setDateToWeekLastDay
import com.kel2.swiftstrider.common.extension.setMinimumTime
import com.kel2.swiftstrider.common.extension.toCalendar
import com.kel2.swiftstrider.data.model.Run
import java.util.Calendar
import java.util.Date

@Immutable
data class RunStatsUiState(
    val dateRange: ClosedRange<Date>,
    val runStats: List<Run>,
    val statisticToShow: Statistic,
    val runStatisticsOnDate: Map<Date, AccumulatedRunStatisticsOnDate>,
) {

    data class AccumulatedRunStatisticsOnDate(
        val date: Date = Date(),
        val distanceInMeters: Int = 0,
        val durationInMillis: Long = 0L,
        val caloriesBurned: Int = 0
    ) {
        operator fun plus(other: AccumulatedRunStatisticsOnDate?) = other?.let {
            AccumulatedRunStatisticsOnDate(
                date = this.date,
                distanceInMeters = this.distanceInMeters + other.distanceInMeters,
                durationInMillis = this.durationInMillis + other.durationInMillis,
                caloriesBurned = this.caloriesBurned + other.caloriesBurned
            )
        } ?: this

        companion object {
            fun fromRun(run: Run) = AccumulatedRunStatisticsOnDate(
                date = run.timestamp.toCalendar().setMinimumTime().time,
                distanceInMeters = run.distanceInMeters,
                durationInMillis = run.durationInMillis,
                caloriesBurned = run.caloriesBurned
            )
        }
    }

    enum class Statistic {
        CALORIES,
        DURATION,
        DISTANCE
    }

    companion object {
        val EMPTY_STATE
            get() = RunStatsUiState(
                dateRange = Calendar.getInstance().setDateToWeekFirstDay().time..
                        Calendar.getInstance().setDateToWeekLastDay().time,
                runStats = emptyList(),
                statisticToShow = Statistic.DISTANCE,
                runStatisticsOnDate = emptyMap()
            )
    }
}
