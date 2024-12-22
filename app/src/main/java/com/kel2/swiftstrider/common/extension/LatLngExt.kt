package com.kel2.swiftstrider.common.extension

import com.google.android.gms.maps.model.LatLng
import com.kel2.swiftstrider.domain.tracking.model.LocationInfo

fun LatLng.toLocationInfo() = LocationInfo(
    longitude = longitude,
    latitude = latitude
)