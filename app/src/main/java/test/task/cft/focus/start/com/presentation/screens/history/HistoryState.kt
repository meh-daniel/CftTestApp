package test.task.cft.focus.start.com.presentation.screens.history

import test.task.cft.focus.start.com.domain.model.Bin

sealed interface HistoryState {
    object Loading : HistoryState
    data class Loaded(val data: List<Bin>) : HistoryState
    object Empty : HistoryState
    data class Error(val error: String) : HistoryState
}