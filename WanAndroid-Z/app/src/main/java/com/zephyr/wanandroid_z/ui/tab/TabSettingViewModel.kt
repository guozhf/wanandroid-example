package com.zephyr.wanandroid_z.ui.tab

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zephyr.baselib.api.HttpResponse
import com.zephyr.baselib.base.BaseViewModel
import com.zephyr.baselib.data.TabEntity
import com.zephyr.wanandroid_z.data.HomeRepository

/**
 * created by zephyr on 2020/12/9 14 : 02
 *
 */
class TabSettingViewModel : BaseViewModel() {
    private val repository: HomeRepository = HomeRepository()

    private val _tabLiveData = MutableLiveData<HttpResponse<List<TabEntity>>>()
    val tabLiveData: LiveData<HttpResponse<List<TabEntity>>> get() = _tabLiveData

    fun getTabs() = launchOnMain(
        callBlock = {
            repository.getTabs()
        },
        successBlock = {
            _tabLiveData.value = it
        },
        failedBlock = {
            _tabLiveData.value = it
        }
    )
}