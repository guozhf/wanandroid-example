package com.zephyr.http.client

import android.util.Log
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.zephyr.http.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * created by zephyr on 2020/12/4 09 : 48
 *
 */
abstract class BaseHttpClient {
    // release不显示日志，debug显示日志，后期加上release的时候也可以显示
    open var isDebug: Boolean = BuildConfig.DEBUG
    private val okHttpClient: OkHttpClient
        get() {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            if (isDebug) {
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                Log.d(Companion.TAG, "debug is open")
            }
            val builder = OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
            initOkHttpClient(builder)
            return builder.build()
        }

    private var retrofit: Retrofit? = null


    fun <T> create(
        baseUrl: String,
        clazz: Class<T>,
        convertFactory: Converter.Factory = GsonConverterFactory.create(),
        callFactory: CallAdapter.Factory = CoroutineCallAdapterFactory()
    ): T {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .addConverterFactory(convertFactory)
                .addCallAdapterFactory(callFactory)
                .build()
        }
        return retrofit!!.create(clazz)

    }


    abstract fun initOkHttpClient(builder: OkHttpClient.Builder)

    companion object {
        private const val TAG = "BaseHttpClient"
    }
}