package com.zephyr.http.exception

/**
 * created by zephyr on 2020/12/10 10 : 09
 * 服务端业务异常
 */
class ServerException(val code: Int,  val errMsg: String) : Exception()