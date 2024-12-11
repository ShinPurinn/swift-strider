package com.kel2.swiftstrider

import android.app.Application
import com.kel2.swiftstrider.background.tracking.service.notification.TrackingNotificationHelper
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class SwiftStriderApp : Application() {
    @Inject
    lateinit var notificationHelper: TrackingNotificationHelper
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        notificationHelper.createNotificationChannel()
    }
}