package com.common.baselibrary.core

/**
 * A generic class that holds a value or error.
 * @param <T>
 */
sealed class Resource<out R> {

    data class Success<out T>(val data: T) : Resource<T>()
    object EmptyData : Resource<Nothing>()
    data class Error(val exception: Exception? = null) : Resource<Nothing>()

    val isSuccess: Boolean get() = this is Success
    val isEmpty: Boolean get() = this is EmptyData
    val isError: Boolean get() = this is Error

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is EmptyData -> "Data is Empty"
            is Error -> "Error[exception=$exception]"
        }
    }
}