package com.example.core.utils

enum class BaseStatus{
    SUCCESS,
    ERROR,
    LOADING
}

sealed class BaseResult <out T> (val status: BaseStatus, val data: T?, val message:String?) {

    data class Success<out R>(val _data: R?): BaseResult<R>(
        status = BaseStatus.SUCCESS,
        data = _data,
        message = null
    )

    data class Error(val exception: String): BaseResult<Nothing>(
        status = BaseStatus.ERROR,
        data = null,
        message = exception
    )

    data class Loading<out R>(val _data: R?, val isLoading: Boolean): BaseResult<R>(
        status = BaseStatus.LOADING,
        data = null,
        message = null
    )
}