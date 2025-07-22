package com.jefryjacky.smartlog.ui.logdetail

import androidx.compose.runtime.Immutable
import com.jefryjacky.smartlog.domain.entity.LogEntity

@Immutable
data class LogDetailState(
    val log: LogEntity? = null
)