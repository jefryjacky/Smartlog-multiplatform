package com.jefryjacky.smartloggingapp

import android.app.Application
import com.jefryjacky.smartlog.LogCatPrinter
import com.jefryjacky.smartlog.SmartLog
import com.jefryjacky.smartlog.di.AppContainer
import com.jefryjacky.smartlog.di.Factory

class SmartLogApp: Application()  {

    override fun onCreate() {
        super.onCreate()
        AppContainer.factory = Factory(this)
        SmartLog.printers.add(LogCatPrinter())
    }
}