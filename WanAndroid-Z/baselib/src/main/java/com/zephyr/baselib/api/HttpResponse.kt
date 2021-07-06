package com.zephyr.baselib.api

import com.zephyr.http.exception.NetworkException

/**
 * created by zephyr on 2020/12/2 16 : 25
 */
sealed class HttpResponse<out R> {
    data class Success<out T>(val data: T?) : HttpResponse<T>()
    data class Failure(val exception: NetworkException) : HttpResponse<Nothing>()
}
