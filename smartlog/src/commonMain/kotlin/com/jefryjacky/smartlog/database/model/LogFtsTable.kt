package com.jefryjacky.smartlog.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Fts4
@Entity(tableName = "log_fts")
@Fts4(contentEntity = LogTable::class)
data class LogFtsTable(
    val tag: String,
    val message: String,
    val error: String
)