package com.zephyr.wanandroid_z.ui.faqs

import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zephyr.baselib.api.HttpResponse
import com.zephyr.baselib.base.BaseFragment
import com.zephyr.baselib.base.BaseVMFragment
import com.zephyr.baselib.data.ArticleEntity
import com.zephyr.baselib.data.TabEntity
import com.zephyr.wanandroid_z.adapters.FaqsAdapter
import com.zephyr.wanandroid_z.databinding.FragmentFaqsBinding

class FAQsFragment : BaseVMFragment<FaqsViewModel, FragmentFaqsBinding>() {

    private lateinit var faqsAdapter: FaqsAdapter
    private val list = mutableListOf<ArticleEntity>()

    override fun createViewModel() = ViewModelProvider(this).get(FaqsViewModel::class.java)

    override fun setupBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFaqsBinding = FragmentFaqsBinding.inflate(inflater, container, false)

    override fun initView() {
        faqsAdapter = FaqsAdapter(list)
        binding.rvFaqs.apply {
            isNestedScrollingEnabled = true
            this.adapter = faqsAdapter
            layoutManager = LinearLayoutManager(requireActivity())
            this.addItemDecoration(object : RecyclerView.ItemDecoration() {
                override fun getItemOffsets(
                    outRect: Rect,
                    view: View,
                    parent: RecyclerView,
                    state: RecyclerView.State
                ) {
                    outRect.bottom = 10
                }

            })
        }
    }

    override fun initListener() {

    }

    override fun initData() {
        baseUIOperate.showLoading(cancelable = true)
        viewModel.getFaqsList(1)
    }

    override fun initViewModel() {
        viewModel.faqsLiveData.observe(this) {
            baseUIOperate.dismissLoading()
            when (it) {
                is HttpResponse.Success<List<ArticleEntity>> -> {
                    if (it.data != null && it.data!!.isNotEmpty()) {
                        list.addAll(it.data!!)
                    }
                    faqsAdapter.notifyDataSetChanged()
                }
                is HttpResponse.Failure -> {
                    baseUIOperate.showToast(it.exception.errorMsg)
                }
            }
        }
    }
}