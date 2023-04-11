package com.common.baselibrary.core

/**
 * UI视图状态顶层接口
 *
 * Created on 2022/12/19.
 * @author Admin
 */

interface State {
    val isLoading: Boolean
    val updateType: String
    val errorMsg: String
}