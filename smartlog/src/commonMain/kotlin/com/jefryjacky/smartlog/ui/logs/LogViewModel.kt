package com.jefryjacky.smartlog.ui.logs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jefryjacky.smartlog.SmartLog
import com.jefryjacky.smartlog.repository.LogRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LogViewModel(
    private val logRepository: LogRepository): ViewModel() {

        private val _state = MutableStateFlow(LogState())


    init {
        viewModelScope.launch {
            getLog()
        }
        viewModelScope.launch {
            SmartLog.v("LogViewModel", "test message1")
            delay(5000)
            SmartLog.d("LogViewModel", "test message2")
            delay(5000)
            SmartLog.i("LogViewModel", "test message3")
            delay(5000)
            SmartLog.w("LogViewModel", "test message4")
            delay(5000)
            SmartLog.e("LogViewModel", "test message5")
            delay(5000)
            SmartLog.wtf("LogViewModel", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
        }
    }
    val state = _state.asStateFlow()

    private suspend fun getLog(){
        logRepository.getLogs().collect { logs->
            _state.update { it.copy(logs = logs) }
        }
    }
}