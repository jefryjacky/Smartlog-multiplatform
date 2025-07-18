package com.jefryjacky.smartlog.domain.entity

import com.jefryjacky.smartlog.LogLevel
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone

data class LogEntity(
    val id: Long,
    val date: LocalDateTime,
    val tag: String,
    val logLevel: LogLevel,
    val message: String,
    val error: String? = null
)