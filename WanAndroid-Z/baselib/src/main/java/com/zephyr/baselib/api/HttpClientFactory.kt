package com.zephyr.baselib.api

import com.zephyr.baselib.interceptors.CommonInterceptor
import com.zephyr.baselib.utils.Constant.COMMON_TIME_OUT
import com.zephyr.http.client.BaseHttpClient
import com.zephyr.http.interceptors.MockInterceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 * created by zephyr on 2020/12/4 15 : 25
 *
 */
object HttpClientFactory : BaseHttpClient() {
    override fun initOkHttpClient(builder: OkHttpClient.Builder) {
        builder
            .readTimeout(COMMON_TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(COMMON_TIME_OUT, TimeUnit.SECONDS)
            .connectTimeout(COMMON_TIME_OUT, TimeUnit.SECONDS)
            .addInterceptor(CommonInterceptor())
            .addInterceptor(MockInterceptor())
        // 添加拦截器，缓存等的地方
    }

    fun request(): Api {
        return create(baseUrl = Api.BASE_URL, clazz = Api::class.java)
    }
}