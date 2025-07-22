package com.jefryjacky.smartlog.repository.database

import com.jefryjacky.smartlog.LogLevel
import com.jefryjacky.smartlog.domain.entity.FilterEntity
import com.jefryjacky.smartlog.domain.entity.LogEntity
import kotlinx.coroutines.flow.Flow

interface LogDatabase {
    fun save(log: LogEntity)
    fun getLogs(): Flow<List<LogEntity>>

    suspend fun getLog(id: Long): LogEntity

    fun filter(logLevel: LogLevel): Flow<List<LogEntity>>

    fun filter(filterEntity: FilterEntity): Flow<List<LogEntity>>
}