package com.jefryjacky.smartlog

import com.jefryjacky.smartlog.di.AppContainer

object SmartLog {
    val printers: MutableList<Printer> by lazy {
        mutableListOf(DatabasePrinter(AppContainer.logRepository))
    }

    fun v(tag: String, message: String){
        printers.forEach { it.log(LogLevel.VERBOSE, tag, message) }
    }

    fun d(tag: String, message: String){
        printers.forEach { it.log(LogLevel.DEBUG, tag, message) }
    }

    fun i(tag: String, message: String){
        printers.forEach { it.log(LogLevel.INFO, tag, message) }
    }

    fun w(tag: String, message: String){
        printers.forEach { it.log(LogLevel.WARN, tag, message) }
    }

    fun e(tag: String, message: String, throwable: Throwable? = null){
        printers.forEach { it.log(LogLevel.ERROR, tag, message, throwable) }
    }

    fun wtf(tag: String, message: String){
        printers.forEach { it.log(LogLevel.ASSERT, tag, message) }
    }
}