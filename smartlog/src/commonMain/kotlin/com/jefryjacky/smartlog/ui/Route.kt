package com.jefryjacky.smartlog.ui

import kotlinx.serialization.Serializable

@Serializable
object Route {
    @Serializable
    object Logs
    @Serializable
    data class LogDetail(val id: Long)
}