package com.common.template.ui

import com.common.baselibrary.core.Action

sealed class MainAction : Action {
    object LoadHomeData : MainAction()
}