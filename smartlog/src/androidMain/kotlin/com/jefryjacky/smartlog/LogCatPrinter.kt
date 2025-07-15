package com.jefryjacky.smartlog

import android.util.Log

class LogCatPrinter(
    private val messageFormatter: MessageFormater = DefaultMessageFormatter()
): Printer {

    override fun log(
        logLevel: LogLevel,
        tag: String,
        message: String,
        throwable: Throwable?
    ) {
        Log.println(logLevel.priority, tag, messageFormatter.format(message, throwable))
    }
}