package com.jefryjacky.smartlog.repository

import com.jefryjacky.smartlog.database.LogDatabaseImpl
import com.jefryjacky.smartlog.domain.entity.LogEntity
import com.jefryjacky.smartlog.repository.database.LogDatabase

class LogRepository(
    private val logDatabase: LogDatabase = LogDatabaseImpl()
) {

    fun save(log: LogEntity) {
        logDatabase.save(log)
    }

    companion object{
        private var instance: LogRepository? = null
    }
}