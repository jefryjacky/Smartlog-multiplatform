package com.jefryjacky.smartlog.ui.logs.filter

import com.jefryjacky.smartlog.LogLevel

sealed interface FilterEvent {
    data class TypingMessageEvent(val message: String) : FilterEvent
    data class TypingTagEvent(val tag: String) : FilterEvent
    data class LogLevelChanged(val logLevel: LogLevel) : FilterEvent
    object Apply : FilterEvent
    object ResetEvent: FilterEvent
    object DismissEvent: FilterEvent
}