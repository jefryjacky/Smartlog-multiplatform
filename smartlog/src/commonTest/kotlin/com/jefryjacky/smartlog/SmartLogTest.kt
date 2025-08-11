package com.jefryjacky.smartlog

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class SmartLogTest {

    private lateinit var mockPrinter: MockPrinter

    @BeforeTest
    fun setUp() {
        mockPrinter = MockPrinter()
        SmartLog.printers.clear()
        SmartLog.printers.add(mockPrinter)
    }

    @Test
    fun `test verbose logging`() {
        // Given a printer is added to SmartLog (in setUp)

        // When
        SmartLog.v("TestTag", "This is a verbose message")

        // Then
        assertEquals(LogLevel.VERBOSE, mockPrinter.logLevel)
        assertEquals("TestTag", mockPrinter.tag)
        assertEquals("This is a verbose message", mockPrinter.message)
        assertNull(mockPrinter.throwable)
    }

    @Test
    fun `test debug logging`() {
        // Given a printer is added to SmartLog (in setUp)

        // When
        SmartLog.d("TestTag", "This is a debug message")

        // Then
        assertEquals(LogLevel.DEBUG, mockPrinter.logLevel)
        assertEquals("TestTag", mockPrinter.tag)
        assertEquals("This is a debug message", mockPrinter.message)
        assertNull(mockPrinter.throwable)
    }

    @Test
    fun `test info logging`() {
        // Given a printer is added to SmartLog (in setUp)

        // When
        SmartLog.i("TestTag", "This is an info message")

        // Then
        assertEquals(LogLevel.INFO, mockPrinter.logLevel)
        assertEquals("TestTag", mockPrinter.tag)
        assertEquals("This is an info message", mockPrinter.message)
        assertNull(mockPrinter.throwable)
    }

    @Test
    fun `test warn logging`() {
        // Given a printer is added to SmartLog (in setUp)

        // When
        SmartLog.w("TestTag", "This is a warning message")

        // Then
        assertEquals(LogLevel.WARN, mockPrinter.logLevel)
        assertEquals("TestTag", mockPrinter.tag)
        assertEquals("This is a warning message", mockPrinter.message)
        assertNull(mockPrinter.throwable)
    }

    @Test
    fun `test error logging`() {
        // Given a printer is added to SmartLog (in setUp)

        // When
        SmartLog.e("TestTag", "This is an error message")

        // Then
        assertEquals(LogLevel.ERROR, mockPrinter.logLevel)
        assertEquals("TestTag", mockPrinter.tag)
        assertEquals("This is an error message", mockPrinter.message)
        assertNull(mockPrinter.throwable)
    }

    @Test
    fun `test error logging with throwable`() {
        // Given a printer is added to SmartLog (in setUp)
        val throwable = RuntimeException("Test exception")

        // When
        SmartLog.e("TestTag", "This is an error message with throwable", throwable)

        // Then
        assertEquals(LogLevel.ERROR, mockPrinter.logLevel)
        assertEquals("TestTag", mockPrinter.tag)
        assertEquals("This is an error message with throwable", mockPrinter.message)
        assertEquals(throwable, mockPrinter.throwable)
    }

    @Test
    fun `test wtf logging`() {
        // Given a printer is added to SmartLog (in setUp)

        // When
        SmartLog.wtf("TestTag", "This is an assert message")

        // Then
        assertEquals(LogLevel.ASSERT, mockPrinter.logLevel)
        assertEquals("TestTag", mockPrinter.tag)
        assertEquals("This is an assert message", mockPrinter.message)
        assertNull(mockPrinter.throwable)
    }

    @Test
    fun `test multiple printers`() {
        // Given
        val anotherMockPrinter = MockPrinter()
        SmartLog.printers.add(anotherMockPrinter)

        // When
        SmartLog.i("MultiPrinter", "A message for multiple printers")

        // Then
        assertEquals(LogLevel.INFO, mockPrinter.logLevel)
        assertEquals("MultiPrinter", mockPrinter.tag)
        assertEquals("A message for multiple printers", mockPrinter.message)

        assertEquals(LogLevel.INFO, anotherMockPrinter.logLevel)
        assertEquals("MultiPrinter", anotherMockPrinter.tag)
        assertEquals("A message for multiple printers", anotherMockPrinter.message)
    }
}

class MockPrinter : Printer {
    var logLevel: LogLevel? = null
    var tag: String? = null
    var message: String? = null
    var throwable: Throwable? = null

    override fun log(level: LogLevel, tag: String, message: String, throwable: Throwable?) {
        this.logLevel = level
        this.tag = tag
        this.message = message
        this.throwable = throwable
    }
}