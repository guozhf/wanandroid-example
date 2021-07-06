package com.zephyr.base_ui

import androidx.annotation.StringRes

/**
 * created by zephyr on 2020/12/11 13 : 44
 *
 */
interface IUIOperate {

    fun showLoading(message: String = "请求中...", cancelable: Boolean = false)

    fun showLoading(@StringRes resId: Int, cancelable: Boolean = false)

    fun dismissLoading()

    fun isLoadingShowing() : Boolean

    fun showToast(message: String? = null)

    fun showToast(@StringRes resId: Int)

}