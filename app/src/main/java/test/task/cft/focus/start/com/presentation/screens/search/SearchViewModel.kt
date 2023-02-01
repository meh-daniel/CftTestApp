package test.task.cft.focus.start.com.presentation.screens.search

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import test.task.cft.focus.start.com.data.toDomain
import test.task.cft.focus.start.com.domain.BinRepository
import java.net.ConnectException
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: BinRepository
): ViewModel() {

    private val _state = MutableStateFlow<SearchState>(SearchState.Loading)
    var state = _state.asStateFlow()

    fun searchBin(bin: String) {
        viewModelScope.launch(Dispatchers.IO) {
            setState(SearchState.Loading)
            try {
                val data = repository.getBy(bin)
                setState(SearchState.Loaded(data))
            } catch (e: Throwable) {
                setState(SearchState.Error(e.message.toString()))
            }
        }
    }

    private fun setState(state: SearchState) {
        viewModelScope.launch(Dispatchers.Main) {
            _state.value = state
        }
    }

}