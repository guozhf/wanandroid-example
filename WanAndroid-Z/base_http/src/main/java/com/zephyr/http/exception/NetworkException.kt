package com.zephyr.http.exception

import com.google.gson.JsonParseException
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.net.ssl.SSLHandshakeException

/**
 * created by zephyr on 2020/12/2 16 : 41
 * 网络请求的异常类，包括网络连接异常，HTTP异常，业务异常
 * HTTP响应代码参考https://developer.mozilla.org/zh-CN/docs/Web/HTTP/Status
 */
class NetworkException : Exception() {

    var errorCode: Int = -1
    var errorMsg: String = "未知错误"

    companion object {
        fun create(throwable: Throwable): NetworkException {
            val exception = NetworkException()
            when (throwable) {
                is HttpException -> {
                    val code = throwable.code()
                    // 可以将网络请求异常细分

                    exception.errorCode = throwable.code()
                    exception.errorMsg = "网络请求失败"
                }
                is ServerException -> {
                    exception.errorCode = throwable.code
                    exception.errorMsg = throwable.errMsg
                }
                is JsonParseException -> {
                    exception.errorCode = NetworkErrorCode.JSON_PARSE_ERROR
                    exception.errorMsg = "数据解析失败"
                }

                is ConnectException, is SocketTimeoutException, is UnknownHostException -> {
                    exception.errorCode = NetworkErrorCode.NETWORK_ERROR
                    exception.errorMsg = "连接服务器失败"
                }
                is SSLHandshakeException -> {
                    exception.errorCode = NetworkErrorCode.SSL_ERROR
                    exception.errorMsg = "证书校验失败"
                }
                else -> {
                    exception.errorCode = NetworkErrorCode.UNKNOWN_ERROR
                    exception.errorMsg = "未知错误"
                }
            }
            return exception
        }
    }
}

class NetworkErrorCode {
    companion object {
        // HTTP


        // SERVER
        const val SERVER_OK = 0
        // .....

        const val JSON_PARSE_ERROR = 1001
        const val NETWORK_ERROR = 1002
        const val SSL_ERROR = 1003
        const val UNKNOWN_ERROR = 1004
    }
}