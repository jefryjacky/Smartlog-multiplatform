package com.jefryjacky.smartlog.database

import com.jefryjacky.smartlog.LogLevel
import com.jefryjacky.smartlog.database.model.LogDao
import com.jefryjacky.smartlog.database.model.LogTable
import com.jefryjacky.smartlog.domain.entity.LogEntity
import com.jefryjacky.smartlog.repository.database.LogDatabase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class LogDatabaseImpl @OptIn(DelicateCoroutinesApi::class) constructor(
    private val dao: LogDao,
    private val scope: CoroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.IO),
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
): LogDatabase {

    override fun save(log: LogEntity) {
        scope.launch(ioDispatcher) {
            dao.insert(LogTable.create(log))
        }
    }

    override fun getLogs(): Flow<List<LogEntity>> {
        return dao.getLogs()
            .flowOn(ioDispatcher)
            .map {
                it.map { it.toEntity() }
            }
    }

    override fun filter(logLevel: LogLevel): Flow<List<LogEntity>> {
        return  dao.filter(logLevel.priority)
            .flowOn(ioDispatcher)
            .map {
                it.map { it.toEntity() }
            }
    }
}