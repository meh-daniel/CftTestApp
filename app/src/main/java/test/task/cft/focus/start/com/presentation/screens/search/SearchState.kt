package test.task.cft.focus.start.com.presentation.screens.search

sealed interface SearchState {
    object Loading : SearchState
    data class Loaded(val repos: Int) : SearchState
    data class Error(val error: String, val isNoConnectionError: Boolean) : SearchState
    object Empty : SearchState
}