package com.jefryjacky.smartlog.database.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface LogDao {
    @Insert
    suspend fun insert(log: LogTable)

    @Query("SELECT * FROM Log ORDER BY date DESC LIMIT 10000")
    fun getLogs(): Flow<List<LogTable>>
}