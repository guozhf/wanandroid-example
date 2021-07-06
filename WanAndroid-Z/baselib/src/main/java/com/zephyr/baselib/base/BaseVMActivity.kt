package com.zephyr.baselib.base

import androidx.viewbinding.ViewBinding

/**
 * created by zephyr on 12/17/20 14 : 45
 *
 */
abstract class BaseVMActivity<VM : BaseViewModel, T : ViewBinding> : BaseActivity2<T>() {

    val viewModel: VM by lazy {
        createViewModel()
    }


    abstract fun createViewModel(): VM
}