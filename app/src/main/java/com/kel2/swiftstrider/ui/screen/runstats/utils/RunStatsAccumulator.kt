package com.kel2.swiftstrider.ui.screen.runstats.utils

import com.kel2.swiftstrider.data.model.Run
import com.kel2.swiftstrider.ui.screen.runstats.RunStatsUiState.AccumulatedRunStatisticsOnDate
import java.util.Date

object RunStatsAccumulator {

    fun accumulateRunByDate(
        list: List<Run>
    ): Map<Date, AccumulatedRunStatisticsOnDate> {
        return buildMap {
            list.forEach { run ->
                val newStats = AccumulatedRunStatisticsOnDate.fromRun(run)
                this[newStats.date] = newStats + this[newStats.date]
            }
        }
    }

}