package com.zephyr.baselib.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.zephyr.base_ui.UIOperateImpl

/**
 * created by zephyr on 2020/12/8 13 : 56
 *
 */
abstract class BaseFragment<out T : ViewBinding> : Fragment() {
    private var _binding: T? = null
    val binding: T
        get() = _binding!!


    protected val baseUIOperate: UIOperateImpl by lazy { UIOperateImpl(requireActivity()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = setupBinding(inflater, container)
        initView()
        initListener()
        initViewModel()
        initData()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    abstract fun setupBinding(inflater: LayoutInflater, container: ViewGroup?): T

    abstract fun initView()

    abstract fun initListener()

    open fun initViewModel() {

    }

    open fun initData() {}

}