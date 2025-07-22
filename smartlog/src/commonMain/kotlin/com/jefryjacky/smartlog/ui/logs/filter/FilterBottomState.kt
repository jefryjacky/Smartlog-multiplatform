package com.jefryjacky.smartlog.ui.logs.filter

import androidx.compose.runtime.Immutable
import com.jefryjacky.smartlog.domain.entity.FilterEntity

@Immutable
data class FilterBottomState(
    val isOpen : Boolean = false,
    val filter: FilterEntity = FilterEntity()
)