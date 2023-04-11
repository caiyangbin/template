package com.common.template.ui

import com.common.baselibrary.core.BaseViewModel
import com.common.template.domain.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    initialState: MainState,
    private val repository: MainRepository
) : BaseViewModel<MainState, MainAction>(initialState) {

    fun onInitHomeData() {
        launchIO {
            dispatch(MainAction.LoadHomeData)
        }
    }

    override suspend fun reduce(currentState: MainState, action: MainAction): MainState {
        if (action is MainAction.LoadHomeData) {
            return getHomeData(currentState)
        }
        return currentState
    }

    private fun getHomeData(currentState: MainState): MainState {
        runCatching {
            repository.getHomeData()
        }.onSuccess {
            return currentState
        }.onFailure {
            return currentState
        }
        return currentState
    }



}