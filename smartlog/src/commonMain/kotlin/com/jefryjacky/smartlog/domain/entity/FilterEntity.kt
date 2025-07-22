package com.jefryjacky.smartlog.domain.entity

import androidx.compose.runtime.Immutable
import com.jefryjacky.smartlog.LogLevel

@Immutable
data class FilterEntity(
    val tag: String = "",
    val message: String = "",
    val logLevel: LogLevel = LogLevel.VERBOSE,
)