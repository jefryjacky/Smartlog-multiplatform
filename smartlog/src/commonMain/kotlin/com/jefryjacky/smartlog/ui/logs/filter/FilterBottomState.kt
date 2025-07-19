package com.jefryjacky.smartlog.ui.logs.filter

import androidx.compose.runtime.Immutable
import com.jefryjacky.smartlog.LogLevel

@Immutable
data class FilterBottomState(
    val isOpen : Boolean = false,
    val search: String = "",
    val logLevel: LogLevel = LogLevel.VERBOSE,
)