package com.jefryjacky.smartlog.ui.logs

sealed interface LogEvent {
    object FilterEvent: LogEvent
}