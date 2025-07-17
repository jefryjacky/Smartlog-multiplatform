package com.jefryjacky.smartlog.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jefryjacky.smartlog.LogLevel
import com.jefryjacky.smartlog.domain.entity.LogEntity
import kotlinx.datetime.LocalDateTime

@Entity(tableName = "Log")
data class LogTable(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val date: String,
    val tag: String,
    @ColumnInfo(name = "log_level")
    val logLevel: Int,
    val message: String,
    val error: String? = null
){

    fun toEntity(): LogEntity{
        return LogEntity(
            date = LocalDateTime.parse(date),
            tag = tag,
            logLevel = LogLevel.fromPriority(logLevel)?: LogLevel.VERBOSE,
            message = message,
            error = error
        )
    }

    companion object{
        fun create(entity: LogEntity): LogTable{
            return LogTable(
                id = 0,
                date = entity.date.toString(),
                tag = entity.tag,
                logLevel = entity.logLevel.priority,
                message = entity.message,
                error = entity.error
            )
        }
    }
}