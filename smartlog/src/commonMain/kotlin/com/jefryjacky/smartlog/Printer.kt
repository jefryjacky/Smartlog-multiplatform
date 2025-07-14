package com.jefryjacky.smartlog

interface Printer {
    fun log(logLevel:LogLevel, tag:String, message: String, throwable: Throwable? = null)
}