package com.zephyr.wanandroid_z.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * created by zephyr on 2020/12/8 15 : 52
 *
 */
class HomeViewPagerAdapter(fragment: Fragment, private val list: List<Fragment>) :
    FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = list.size

    override fun createFragment(position: Int): Fragment = list[position]
}