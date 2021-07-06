package com.zephyr.baselib.api

/**
 * created by zephyr on 2020/12/2 16 : 06
 * 网络请求响应体外层结构
 */
data class ApiResponse<out T>(val data: T?, var errorCode: Int, var errorMsg: String)