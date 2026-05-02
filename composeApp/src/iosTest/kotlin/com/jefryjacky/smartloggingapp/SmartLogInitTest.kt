package com.jefryjacky.smartloggingapp

import com.jefryjacky.smartlog.LogCatPrinter
import com.jefryjacky.smartlog.SmartLog
import com.jefryjacky.smartlog.di.AppContainer
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class SmartLogInitTest {

    @BeforeTest
    fun setup() {
        // Reset state if possible
        SmartLog.printers.clear()
    }

    @Test
    fun testInitSmartlog() {
        initializeSmartlog()
        assertNotNull(AppContainer.factory)
        assertTrue(SmartLog.printers.any { it is LogCatPrinter })
    }
}
