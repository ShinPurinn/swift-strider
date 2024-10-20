package com.kel2.SwiftStrider.domain.tracking.location

import com.kel2.SwiftStrider.domain.tracking.model.LocationTrackingInfo

interface LocationTrackingManager {
    fun setCallback(locationCallback: LocationCallback)

    fun removeCallback()

    interface LocationCallback {
        fun onLocationUpdate(results: List<LocationTrackingInfo>)
    }
}