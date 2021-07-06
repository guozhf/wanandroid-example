package com.zephyr.http.interceptors

import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

/**
 * created by zephyr on 2020/12/11 11 : 36
 *
 */
class MockInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newBuilder = request.newBuilder()
        val response = chain.proceed(newBuilder.build())
        val responseBuilder = response.newBuilder()
//        responseBuilder.code(200)
//
//        val json = "{\"data\":[], \"errorCode\":401, \"errorMsg\":\"fake message:failed\"}"
//
//        val body =
//            json.toResponseBody("application/json; charset=utf-8".toMediaTypeOrNull())
//
//        responseBuilder.body(body)
//        return responseBuilder.build()
        return response
    }

}