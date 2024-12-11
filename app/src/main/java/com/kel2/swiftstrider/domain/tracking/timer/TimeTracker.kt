package com.kel2.swiftstrider.domain.tracking.timer

interface TimeTracker {
    fun startResumeTimer(callback: (timeInMillis: Long) -> Unit)

    fun stopTimer()

    fun pauseTimer()

}