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
                if(data.brand.isEmpty()) {
                    setState(SearchState.Empty)
                } else {
                    setState(SearchState.Loaded(data))
                }
                Log.d("xxx123", "nw ${data}")
            } catch (e: Throwable) {
                Log.d("xxx123", "nw $e")
                when (e) {
                    is ConnectException -> setState(SearchState.Error(e.message.toString(), true))
                    else -> setState(SearchState.Error(e.message.toString(), false))
                }
            }
        }
    }

    private fun setState(state: SearchState) {
        viewModelScope.launch(Dispatchers.Main) {
            _state.value = state
        }
    }

}