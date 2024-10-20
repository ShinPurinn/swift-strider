package com.kel2.SwiftStrider.domain.tracking.timer

interface TimeTracker {
    fun startResumeTimer(callback: (timeInMillis: Long) -> Unit)

    fun stopTimer()

    fun pauseTimer()

}