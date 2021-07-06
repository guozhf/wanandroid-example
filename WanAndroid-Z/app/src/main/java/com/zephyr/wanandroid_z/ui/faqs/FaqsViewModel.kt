package com.zephyr.wanandroid_z.ui.faqs

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zephyr.baselib.api.HttpResponse
import com.zephyr.baselib.base.BaseViewModel
import com.zephyr.baselib.data.ArticleEntity
import com.zephyr.wanandroid_z.data.FaqsRepository

class FaqsViewModel : BaseViewModel() {

    private val repository: FaqsRepository = FaqsRepository()
    private val _faqsLiveData = MutableLiveData<HttpResponse<List<ArticleEntity>>>()
    val faqsLiveData: LiveData<HttpResponse<List<ArticleEntity>>> = _faqsLiveData

    fun getFaqsList(pageNum: Int) {
        launchOnMain(
            callBlock = {
                repository.getFaqs(pageNum)
            },
            successBlock = {
                _faqsLiveData.value = it
            },
            failedBlock = {
                _faqsLiveData.value = it
            },
        )
    }


}