package com.zephyr.baselib.interceptors

import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody


/**
 * created by zephyr on 2020/12/2 14 : 16
 *
 */
class CommonInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newBuilder = request.newBuilder()
        val response = chain.proceed(newBuilder.build())
        return response
    }

}


