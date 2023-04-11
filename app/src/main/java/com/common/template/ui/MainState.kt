package com.common.template.ui

import com.common.baselibrary.core.State
import javax.inject.Inject

data class MainState(
    override val isLoading: Boolean,
    override val updateType: String,
    override val errorMsg: String,
    val homeData: List<String>,
) : State {

    @Inject
    constructor() : this(false, "", "", emptyList())

}