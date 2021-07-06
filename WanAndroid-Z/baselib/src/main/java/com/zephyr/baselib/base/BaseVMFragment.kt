package com.zephyr.baselib.base

import androidx.viewbinding.ViewBinding

/**
 * created by zephyr on 12/17/20 14 : 48
 *
 */
abstract class BaseVMFragment<VM : BaseViewModel, T : ViewBinding> : BaseFragment<T>() {

    protected val viewModel: VM by lazy {
        createViewModel()
    }

    abstract fun createViewModel(): VM
}