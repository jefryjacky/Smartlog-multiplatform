package com.jefryjacky.smartlog.ui.logdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jefryjacky.smartlog.repository.LogRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LogDetailViewModel (
    private val logRepository: LogRepository
): ViewModel() {
    private val _state = MutableStateFlow(LogDetailState())
    val state = _state.asStateFlow()

    var id: Long = 0
        set(value) {
            viewModelScope.launch {
                val log = logRepository.getLog(value)
                _state.value = _state.value.copy(log = log)
            }
        }
}