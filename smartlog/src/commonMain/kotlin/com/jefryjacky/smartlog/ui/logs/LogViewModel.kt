package com.jefryjacky.smartlog.ui.logs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jefryjacky.smartlog.repository.LogRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LogViewModel(
    private val logRepository: LogRepository): ViewModel() {

        private val _state = MutableStateFlow(LogState())


    init {
        viewModelScope.launch {
            getLog()
        }
    }
    val state = _state.asStateFlow()

    private suspend fun getLog(){
        logRepository.getLogs().collect { logs->
            _state.value = _state.value.copy(logs = logs)
        }
    }
}