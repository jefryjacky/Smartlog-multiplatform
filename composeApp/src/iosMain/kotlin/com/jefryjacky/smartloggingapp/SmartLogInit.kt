package com.jefryjacky.smartloggingapp

import com.jefryjacky.smartlog.LogCatPrinter
import com.jefryjacky.smartlog.SmartLog
import com.jefryjacky.smartlog.di.AppContainer
import com.jefryjacky.smartlog.di.Factory

fun initializeSmartlog() {
    AppContainer.factory = Factory()
    if (SmartLog.printers.none { it is LogCatPrinter }) {
        SmartLog.printers.add(LogCatPrinter())
    }
}
