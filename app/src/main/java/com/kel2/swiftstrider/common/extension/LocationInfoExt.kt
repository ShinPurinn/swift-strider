package com.kel2.swiftstrider.common.extension

import com.google.android.gms.maps.model.LatLng
import com.kel2.swiftstrider.domain.tracking.model.LocationInfo

fun LocationInfo.toLatLng() = LatLng(
    latitude,
    longitude
)