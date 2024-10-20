package com.kel2.SwiftStrider.common.extension

import com.google.android.gms.maps.model.LatLng
import com.kel2.SwiftStrider.domain.tracking.model.LocationInfo

fun LocationInfo.toLatLng() = LatLng(
    latitude,
    longitude
)