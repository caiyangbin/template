package com.common.baselibrary.core

/**
 * 返回事件, 例如 toast 等
 *
 * Created on 2022/12/19.
 * @author Admin
 */
sealed interface Event {
    data class ShowToast(val msg: String) : Event
}