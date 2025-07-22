package com.jefryjacky.smartlog.ui.logs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jefryjacky.smartlog.SmartLog
import com.jefryjacky.smartlog.domain.entity.FilterEntity
import com.jefryjacky.smartlog.repository.LogRepository
import com.jefryjacky.smartlog.ui.logs.filter.FilterBottomState
import com.jefryjacky.smartlog.ui.logs.filter.FilterEvent
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LogViewModel(
    private val logRepository: LogRepository): ViewModel() {
    private lateinit var job: Job

        private val _state = MutableStateFlow(LogState())


    init {
            getLog()
    }
    val state = _state.asStateFlow()
    private val _filterBottomSheet = MutableStateFlow(FilterBottomState())
    val filterBottomSheet = _filterBottomSheet.asStateFlow()

    private fun getLog(){
        job = viewModelScope.launch {
            logRepository.getLogs().collect { logs ->
                _state.update { it.copy(logs = logs, isFilterOn = false) }
            }
        }
    }

    fun handleEvent(event: LogEvent){
        when(event){
            is LogEvent.FilterEvent -> {
                _filterBottomSheet.update { it.copy(isOpen = !it.isOpen) }
            }
            is LogEvent.ScrollTopEvent -> {
                _state.update {
                    it.copy(isScrollToTop = !it.isScrollToTop)
                }
            }

            is LogEvent.PlayStopEvent -> {
                if(state.value.isPlaying){
                    job.cancel()
                } else {
                    if(state.value.isFilterOn){
                     filter()
                    } else {
                        getLog()
                    }
                }
                _state.update { it.copy(isPlaying = !it.isPlaying) }
            }

            else -> {}
        }
    }

    fun handleFilterEvent(event: FilterEvent){
        when(event){
            is FilterEvent.DismissEvent -> {
                _filterBottomSheet.update { it.copy(isOpen = false) }
            }
            is FilterEvent.LogLevelChanged -> {
                _filterBottomSheet.update { it.copy(filter = it.filter.copy(logLevel = event.logLevel)) }
            }

            FilterEvent.Apply -> {
                _filterBottomSheet.update { it.copy(isOpen = false) }
                job.cancel()
                filter()
            }
            FilterEvent.ResetEvent -> {
                job.cancel()
                _filterBottomSheet.update { it.copy(filter = FilterEntity(), isOpen = false) }
                getLog()
            }
            is FilterEvent.TypingMessageEvent -> {
                _filterBottomSheet.update { it.copy(filter = it.filter.copy(message = event.message)) }
            }
            is FilterEvent.TypingTagEvent -> {
                _filterBottomSheet.update { it.copy(filter = it.filter.copy(tag = event.tag)) }
            }
        }
    }

    private fun filter(){
        job = viewModelScope.launch {
            logRepository.filter(filterBottomSheet.value.filter)
                .collect { result->
                    _state.update { it.copy(logs = result, isFilterOn = true) }
                }
        }
    }
}