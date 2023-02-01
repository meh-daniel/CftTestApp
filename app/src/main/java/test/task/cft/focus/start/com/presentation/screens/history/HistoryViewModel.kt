package test.task.cft.focus.start.com.presentation.screens.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import test.task.cft.focus.start.com.domain.BinRepository
import test.task.cft.focus.start.com.presentation.screens.search.SearchState
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val repository: BinRepository
): ViewModel() {

    private val _state = MutableStateFlow<HistoryState>(HistoryState.Loading)
    var state = _state.asStateFlow()

    init {
        loadBinList()
    }

    private fun loadBinList() {
        viewModelScope.launch(Dispatchers.IO) {
            setState(HistoryState.Loading)
            try {
                val data = repository.get()
                if (data.isEmpty()) {
                    setState(HistoryState.Empty)
                } else {
                    setState(HistoryState.Loaded(data))
                }
            } catch (e: Throwable) {
                setState(HistoryState.Error(e.message.toString()))
            }
        }
    }

    private fun setState(state: HistoryState) {
        viewModelScope.launch(Dispatchers.Main) {
            _state.value = state
        }
    }


}