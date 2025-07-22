package com.jefryjacky.smartlog.di

import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.jefryjacky.smartlog.database.LogDatabaseImpl
import com.jefryjacky.smartlog.repository.LogRepository
import com.jefryjacky.smartlog.ui.logdetail.LogDetailViewModel
import com.jefryjacky.smartlog.ui.logs.LogViewModel

object AppContainer{
    lateinit var factory: Factory

    private val database by lazy {
        factory.createRoomDatabase()
    }
    val logRepository: LogRepository by lazy {
        LogRepository(
            logDatabase = LogDatabaseImpl(database.getLogDao()))
    }

    val logViewModel = viewModelFactory {
        initializer{
            LogViewModel(logRepository)
        }
    }

    val logDetailViewModel = viewModelFactory {
        initializer{
            LogDetailViewModel(logRepository)
        }
    }
}