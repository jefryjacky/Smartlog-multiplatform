package com.jefryjacky.smartlog.database.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface LogDao {
    @Insert
    suspend fun insert(log: LogTable)

    @Query("SELECT * FROM Log")
    fun getLogs(): Flow<List<LogTable>>
}