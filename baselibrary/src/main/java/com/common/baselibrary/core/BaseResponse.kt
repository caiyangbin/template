package com.common.baselibrary.core

/**
 * Created on 2022/12/19.
 * @author Admin
 */

data class BaseResponse<T>(
    var status: Int = STATUS_CODE_ERROR,
    var data: T? = null,
    var error: String? = null
) {
    companion object {
        const val STATUS_CODE_ERROR = -1
        const val STATUS_CODE_SUCCESS = 0
    }

    val succeeded: Boolean
        get() = status == STATUS_CODE_SUCCESS
}
