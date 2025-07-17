package com.jefryjacky.smartlog.ui.logs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jefryjacky.smartlog.repository.LogRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
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
//        .onStart {
//            getLog()
//
//        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), LogState())

    private suspend fun getLog(){
        logRepository.getLogs().collect { logs->
            _state.value = _state.value.copy(logs = logs)
        }
    }
}