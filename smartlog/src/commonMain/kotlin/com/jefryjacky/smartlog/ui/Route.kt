package com.jefryjacky.smartlog.ui

import kotlinx.serialization.Serializable

enum class Route(val routename: String) {
    LOGS("logs"),
    LOGS_DETAIL("log/detail")
}