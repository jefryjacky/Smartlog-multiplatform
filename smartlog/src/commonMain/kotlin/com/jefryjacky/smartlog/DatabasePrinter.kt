package com.jefryjacky.smartlog

import com.jefryjacky.smartlog.domain.entity.LogEntity
import com.jefryjacky.smartlog.repository.LogRepository
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

class DatabasePrinter constructor(
    private val logRepository: LogRepository
): Printer {
    @OptIn(ExperimentalTime::class)
    override fun log(
        logLevel: LogLevel,
        tag: String,
        message: String,
        throwable: Throwable?
    ) {
        val entity = LogEntity(
            id = 0,
            date = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()),
            logLevel = logLevel,
            tag = tag,
            message = message,
            error = throwable?.message
        )
        logRepository.save(entity)
    }
}