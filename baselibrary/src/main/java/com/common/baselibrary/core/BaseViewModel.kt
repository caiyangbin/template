package com.common.baselibrary.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created on 2022/12/19.
 * @author Admin
 */

abstract class BaseViewModel<S : State, A : Action>(
    initialState: S
) : ViewModel() {

    // UI状态, 粘性(即只发送最新数据),可以防抖
    private val _state = MutableStateFlow(initialState)
    val state = _state.asStateFlow()

    // UI状态, 非粘性(保证每次发送State都能到达)，适用无论如何都需要刷新数据的情况
    private val _forceUpdateState = MutableSharedFlow<S>()
    val forceUpdateState = _forceUpdateState.asSharedFlow()

    // loading event, 非粘性(保证每次发送Event都能到达)
    private val _event = MutableSharedFlow<Event>()
    val event = _event.asSharedFlow()

    private val currentState: S get() = _state.value

    protected suspend fun dispatch(action: A) {
        val newState = reduce(currentState, action)
        _state.value = newState
        _forceUpdateState.emit(newState)
    }

    protected suspend fun showToast(msg: String) {
        _event.emit(Event.ShowToast(msg))
    }

    protected abstract suspend fun reduce(currentState: S, action: A): S

    protected inline fun launchIO(crossinline block: suspend () -> Unit): Job {
        return viewModelScope.launch(Dispatchers.IO) {
            block.invoke()
        }
    }

    protected inline fun launchUI(crossinline block: suspend () -> Unit): Job {
        return viewModelScope.launch(Dispatchers.Main) {
            block.invoke()
        }
    }

    protected suspend inline fun withUI(crossinline block: suspend () -> Unit) {
        withContext(Dispatchers.Main) {
            block.invoke()
        }
    }

    protected suspend inline fun withIO(crossinline block: suspend () -> Unit) {
        withContext(Dispatchers.IO) {
            block.invoke()
        }
    }
}

