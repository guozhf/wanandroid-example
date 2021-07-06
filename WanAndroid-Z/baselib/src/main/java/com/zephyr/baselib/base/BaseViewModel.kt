package com.zephyr.baselib.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zephyr.http.exception.NetworkException
import com.zephyr.baselib.api.HttpResponse
import kotlinx.coroutines.*

/**
 * created by zephyr on 2020/12/4 16 : 51
 *
 */
open class BaseViewModel : ViewModel() {

    private suspend fun <T> requestOnce(
        callBlock: suspend CoroutineScope.() -> HttpResponse<T>,
        successBlock: suspend CoroutineScope.(response: HttpResponse.Success<T>) -> Unit,
        failedBlock: suspend CoroutineScope.(response: HttpResponse.Failure) -> Unit
    ) {
        coroutineScope {
            val response = try {
                callBlock()
            } catch (ex: Exception) {
                HttpResponse.Failure(NetworkException.create(ex))
            }

            when (response) {
                is HttpResponse.Success<T> -> successBlock(response)
                is HttpResponse.Failure -> failedBlock(response)
            }
        }
    }

    protected fun <T> launchOnMain(
        callBlock: suspend CoroutineScope.() -> HttpResponse<T>,
        successBlock: suspend CoroutineScope.(response: HttpResponse.Success<T>) -> Unit,
        failedBlock: suspend CoroutineScope.(response: HttpResponse.Failure) -> Unit
    ) {
        viewModelScope.launch {
            requestOnce(callBlock, successBlock, failedBlock)
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}