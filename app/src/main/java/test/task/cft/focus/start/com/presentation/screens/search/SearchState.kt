package test.task.cft.focus.start.com.presentation.screens.search

import test.task.cft.focus.start.com.domain.model.Bin

sealed interface SearchState {
    object Loading : SearchState
    data class Loaded(val data: Bin) : SearchState
    data class Error(val error: String) : SearchState
}