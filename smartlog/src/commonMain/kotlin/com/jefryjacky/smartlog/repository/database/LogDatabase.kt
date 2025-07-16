package com.jefryjacky.smartlog.repository.database

import com.jefryjacky.smartlog.domain.entity.LogEntity

interface LogDatabase {
    fun save(log: LogEntity)
}