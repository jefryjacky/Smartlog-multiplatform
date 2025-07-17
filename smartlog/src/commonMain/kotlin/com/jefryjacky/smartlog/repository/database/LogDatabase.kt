package com.jefryjacky.smartlog.repository.database

import com.jefryjacky.smartlog.domain.entity.LogEntity
import kotlinx.coroutines.flow.Flow

interface LogDatabase {
    fun save(log: LogEntity)
    fun getLogs(): Flow<List<LogEntity>>
}