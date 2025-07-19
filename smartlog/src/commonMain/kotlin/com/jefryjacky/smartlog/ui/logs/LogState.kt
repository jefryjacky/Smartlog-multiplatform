package com.jefryjacky.smartlog.ui.logs

import androidx.compose.runtime.Immutable
import com.jefryjacky.smartlog.domain.entity.LogEntity

data class LogState(
    val logs:List<LogEntity> = emptyList(),
)
