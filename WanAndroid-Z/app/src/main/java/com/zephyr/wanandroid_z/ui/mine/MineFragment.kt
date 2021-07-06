package com.zephyr.wanandroid_z.ui.mine

import android.view.LayoutInflater
import android.view.ViewGroup
import com.zephyr.baselib.base.BaseFragment
import com.zephyr.wanandroid_z.databinding.FragmentMineBinding
import java.lang.RuntimeException

/**
 * created by zephyr on 2020/12/11 17 : 03
 *
 */
class MineFragment : BaseFragment<FragmentMineBinding>() {
    override fun setupBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMineBinding = FragmentMineBinding.inflate(inflater, container, false)

    override fun initView() {
        binding.titleLayout.setOnClickListener {
            throw RuntimeException("dddddddddd")
        }
    }

    override fun initListener() {
    }

    override fun initViewModel() {
    }
}