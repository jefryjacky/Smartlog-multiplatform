package com.jefryjacky.smartlog.domain.entity

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone

data class LogEntity(
    val date: LocalDateTime,
    val timezone: TimeZone,
    val tag: String,
    val message: String,
    val error: String? = null
)