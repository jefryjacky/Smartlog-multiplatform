package com.jefryjacky.smartlog.ui.logs

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import com.jefryjacky.smartlog.domain.entity.LogEntity

data class LogState(
    val isScrollToTop:Boolean = true,
    val logs:List<LogEntity> = emptyList(),
){
    @Composable
    fun getIconScrollTopColor(): Color{
        return if(isScrollToTop){
            MaterialTheme.colorScheme.primary
        } else {
            Color.White
        }
    }
}
