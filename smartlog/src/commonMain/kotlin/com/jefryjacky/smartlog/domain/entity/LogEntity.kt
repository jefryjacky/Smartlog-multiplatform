package com.jefryjacky.smartlog.domain.entity

import androidx.compose.runtime.Immutable
import com.jefryjacky.smartlog.LogLevel
import kotlinx.datetime.LocalDateTime

@Immutable
data class LogEntity(
    val id: Long,
    val date: LocalDateTime,
    val tag: String,
    val logLevel: LogLevel,
    val message: String,
    val error: String? = null
)