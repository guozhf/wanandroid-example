package com.zephyr.wanandroid_z.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayoutMediator
import com.zephyr.baselib.base.BaseFragment
import com.zephyr.wanandroid_z.adapters.HomeViewPagerAdapter
import com.zephyr.wanandroid_z.databinding.FragmentHomeBinding
import com.zephyr.wanandroid_z.databinding.LayoutSearchBinding
import com.zephyr.wanandroid_z.test.TestFragment
import com.zephyr.wanandroid_z.ui.search.SearchActivity
import com.zephyr.wanandroid_z.ui.tab.TabSettingActivity


class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    private lateinit var homeViewModel: HomeViewModel
    private val tabFragmentList = mutableListOf<Fragment>(TestFragment())
    private val mediator by lazy {
        attachViewPagerWithTab()
    }

    override fun setupBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding =
        FragmentHomeBinding.inflate(inflater, container, false)

    override fun initView() {
        binding.viewpager.adapter = HomeViewPagerAdapter(this, tabFragmentList)
        mediator.attach()
    }

    override fun initListener() {
        val searchBinding = binding.includeHead
        searchBinding.tvAdd.setOnClickListener {
            TabSettingActivity.start(requireActivity())
        }
        searchBinding.tvSearch.setOnClickListener {
            SearchActivity.start(requireActivity())
        }
    }

    override fun initViewModel() {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        homeViewModel.tabLiveData.observe(this, Observer {
            val range = 0..it
            tabFragmentList.clear()
            for (i in range) {
                val testFragment = TestFragment()
                tabFragmentList.add(testFragment)
            }
            binding.viewpager.adapter!!.notifyDataSetChanged()
        })
    }

    private fun attachViewPagerWithTab() = TabLayoutMediator(
        binding.tablayout, binding.viewpager, true, true
    ) { tab, position -> tab.text = "测试 $position" }
}