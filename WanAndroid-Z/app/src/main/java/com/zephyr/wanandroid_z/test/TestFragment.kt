package com.zephyr.wanandroid_z.test

import android.view.LayoutInflater
import android.view.ViewGroup
import com.zephyr.baselib.base.BaseFragment
import com.zephyr.wanandroid_z.databinding.FragmentFaqsBinding

/**
 * created by zephyr on 2020/12/8 15 : 49
 *
 */
class TestFragment : BaseFragment<FragmentFaqsBinding>() {
    override fun setupBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFaqsBinding = FragmentFaqsBinding.inflate(inflater, container, false)

    override fun initView() {

    }

    override fun initViewModel() {
    }

    override fun initListener() {

    }
}