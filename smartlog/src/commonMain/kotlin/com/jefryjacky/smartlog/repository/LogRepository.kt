package com.jefryjacky.smartlog.repository

import com.jefryjacky.smartlog.LogLevel
import com.jefryjacky.smartlog.database.LogDatabaseImpl
import com.jefryjacky.smartlog.domain.entity.FilterEntity
import com.jefryjacky.smartlog.domain.entity.LogEntity
import com.jefryjacky.smartlog.repository.database.LogDatabase
import com.jefryjacky.smartlog.ui.logs.filter.FilterBottomState
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

    suspend fun getLog(id: Long): LogEntity {
        return logDatabase.getLog(id)
    }

    fun filter(logLevel: LogLevel): Flow<List<LogEntity>> {
        return logDatabase.filter(logLevel)
    }

    fun filter(filter: FilterEntity): Flow<List<LogEntity>> {
        return logDatabase.filter(filter)
    }

    suspend fun deleteAll() {
        logDatabase.deleteAll()
    }

    companion object{
        private var instance: LogRepository? = null
    }
}