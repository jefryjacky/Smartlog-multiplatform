package com.jefryjacky.smartlog

import platform.Foundation.NSLog
import platform.Foundation.NSString

class LogCatPrinter(
    private val messageFormatter: MessageFormater = DefaultMessageFormatter()
): Printer {

    override fun log(
        logLevel: LogLevel,
        tag: String,
        message: String,
        throwable: Throwable?
    ) {
        val formattedMessage = messageFormatter.format(message, throwable)
        val logString = "[${logLevel.levelName}] $tag: $formattedMessage"
        NSLog("%@", logString as NSString)
    }
}
