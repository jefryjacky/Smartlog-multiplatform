package com.jefryjacky.smartlog.database.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.jefryjacky.smartlog.LogLevel
import kotlinx.coroutines.flow.Flow

@Dao
interface LogDao {
    @Insert
    suspend fun insert(log: LogTable)

    @Query("SELECT * FROM Log ORDER BY date DESC LIMIT 10000")
    fun getLogs(): Flow<List<LogTable>>

    @Query("SELECT * FROM Log  WHERE log_level >= :logLevel ORDER BY date DESC LIMIT 10000")
    fun filter(logLevel: Int): Flow<List<LogTable>>

    @Query("SELECT * FROM Log JOIN log_fts ON log.id = log_fts.rowid WHERE log_fts MATCH :query AND log_level >= :logLevel ORDER BY date DESC LIMIT 10000")
    fun filter(query: String, logLevel: Int = LogLevel.VERBOSE.priority): Flow<List<LogTable>>
}