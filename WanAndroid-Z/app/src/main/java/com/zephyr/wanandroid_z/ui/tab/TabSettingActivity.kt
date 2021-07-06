package com.zephyr.wanandroid_z.ui.tab

import android.app.Activity
import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zephyr.baselib.api.HttpResponse
import com.zephyr.baselib.base.BaseActivity
import com.zephyr.baselib.data.TabEntity
import com.zephyr.wanandroid_z.adapters.TabAdapter
import com.zephyr.wanandroid_z.databinding.ActivityTabSettingBinding

/**
 * created by zephyr on 2020/12/9 09 : 57
 *
 */
class TabSettingActivity : BaseActivity() {

    private lateinit var binding: ActivityTabSettingBinding
    private val viewModel: TabSettingViewModel by lazy {
        ViewModelProvider(this).get(TabSettingViewModel::class.java)
    }
    private lateinit var adapter: TabAdapter

    private val tabList = mutableListOf<TabEntity>()

    companion object {
        fun start(activity: Activity) {
            val intent = Intent(activity, TabSettingActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTabSettingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        viewModel.getTabs()
        observe()
        baseUIOperate.showLoading(cancelable = true)
    }

    private fun initView() {
        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        adapter = TabAdapter(tabList)
        binding.rvTab.apply {
            setHasFixedSize(true)
            isNestedScrollingEnabled = true
            this.adapter = this@TabSettingActivity.adapter
            this.layoutManager = GridLayoutManager(this@TabSettingActivity, 3)
            this.addItemDecoration(object : RecyclerView.ItemDecoration() {
                override fun getItemOffsets(
                    outRect: Rect,
                    view: View,
                    parent: RecyclerView,
                    state: RecyclerView.State
                ) {
                    val position =
                        (view.layoutParams as RecyclerView.LayoutParams).viewLayoutPosition
                    when {
                        position % 3 == 0 -> outRect.set(0, 0, 25, 50)
                        (position + 1) % 3 == 0 -> outRect.set(25, 0, 0, 50)
                        else -> outRect.set(25, 0, 25, 50)
                    }
                }

            })
        }
        binding.rvTabSelected.apply {
            setHasFixedSize(true)
            isNestedScrollingEnabled = true
            this.adapter = this@TabSettingActivity.adapter
            this.layoutManager = GridLayoutManager(this@TabSettingActivity, 3)
            this.addItemDecoration(object : RecyclerView.ItemDecoration() {
                override fun getItemOffsets(
                    outRect: Rect,
                    view: View,
                    parent: RecyclerView,
                    state: RecyclerView.State
                ) {
                    val position =
                        (view.layoutParams as RecyclerView.LayoutParams).viewLayoutPosition
                    when {
                        position % 3 == 0 -> outRect.set(0, 0, 25, 50)
                        (position + 1) % 3 == 0 -> outRect.set(25, 0, 0, 50)
                        else -> outRect.set(25, 0, 25, 50)
                    }
                }

            })
        }
    }

    private fun observe() {
        viewModel.tabLiveData.observe(this) {
            baseUIOperate.dismissLoading()
            when (it) {
                is HttpResponse.Success<List<TabEntity>> -> {
                    if (it.data != null && it.data!!.isNotEmpty()) {
                        tabList.addAll(it.data!!)
                    }
                    adapter.notifyDataSetChanged()
                }
                is HttpResponse.Failure -> {
                    baseUIOperate.showToast(it.exception.errorMsg)
                }
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

}


