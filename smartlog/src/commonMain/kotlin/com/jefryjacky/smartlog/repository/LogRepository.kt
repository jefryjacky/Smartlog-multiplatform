package com.jefryjacky.smartlog.repository

import com.jefryjacky.smartlog.LogLevel
import com.jefryjacky.smartlog.database.LogDatabaseImpl
import com.jefryjacky.smartlog.domain.entity.LogEntity
import com.jefryjacky.smartlog.repository.database.LogDatabase
import kotlinx.coroutines.flow.Flow

class LogRepository(
    private val logDatabase: LogDatabase
) {
    fun save(log: LogEntity) {
        logDatabase.save(log)
    }

    fun getLogs(): Flow<List<LogEntity>> {
        return logDatabase.getLogs()
    }

    fun filter(logLevel: LogLevel): Flow<List<LogEntity>> {
        return logDatabase.filter(logLevel)
    }

    companion object{
        private var instance: LogRepository? = null
    }
}