package com.jefryjacky.smartlog.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.jefryjacky.smartlog.database.model.LogDao
import com.jefryjacky.smartlog.database.model.LogFtsTable
import com.jefryjacky.smartlog.database.model.LogTable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

@Database(entities = [LogTable::class, LogFtsTable::class], version = 1)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class AppRoomDatabase: RoomDatabase() {
    abstract fun getLogDao(): LogDao
}

// The Room compiler generates the `actual` implementations.
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<AppRoomDatabase> {
    override fun initialize(): AppRoomDatabase
}

fun getRoomDatabase(
    builder: RoomDatabase.Builder<AppRoomDatabase>
): AppRoomDatabase {
    return builder
//        .addMigrations(AutoMigration)
//        .fallbackToDestructiveMigrationOnDowngrade()
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}