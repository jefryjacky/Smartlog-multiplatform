package com.jefryjacky.smartlog.ui.logs

sealed interface LogEvent {
    object FilterEvent: LogEvent
    object ScrollTopEvent: LogEvent
    object PlayStopEvent: LogEvent
    data class CardClickEvent(val id: Long): LogEvent
}