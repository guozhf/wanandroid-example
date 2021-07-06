package com.zephyr.wanandroid_z.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zephyr.baselib.api.HttpResponse
import com.zephyr.baselib.data.ArticleEntity
import com.zephyr.baselib.data.BannerEntity
import com.zephyr.wanandroid_z.data.HomeRepository
import kotlinx.coroutines.launch
import java.lang.Exception
import java.net.ConnectException
import java.net.SocketTimeoutException

class HomeViewModel : ViewModel() {

    private val _tabLiveData = MutableLiveData<Int>().apply {
        value = 5
    }
    val tabLiveData: LiveData<Int> get() = _tabLiveData // 测试用





    // 以下内容备用
    private val repository: HomeRepository = HomeRepository()

    private val _bannerData = MutableLiveData<List<BannerEntity>>()
    val bannerData: LiveData<List<BannerEntity>> = _bannerData

    private val _articleData = MutableLiveData<List<ArticleEntity>>()
    val articleData: LiveData<List<ArticleEntity>> = _articleData

    private val _requestError = MutableLiveData<String>()
    val requestError: LiveData<String> = _requestError
//    fun getBanner() {
//        viewModelScope.launch {
//            var banner = try {
//                // 请求成功
//                repository.getBanner()
//            } catch (ex: Exception) {
//                // 请求失败
//                var failure = when (ex) {
//                    is ConnectException -> HttpResponse.Failure(-1, "网络连接失败")
//                    is SocketTimeoutException -> HttpResponse.Failure(-1, "网络连接超时")
//                    //                    is HttpException
//                    else -> HttpResponse.Failure(-1, "未知错误")
//                }
//                failure
//            }
//            when (banner) {
//                is HttpResponse.Success -> _bannerData.value = banner.data
//                is HttpResponse.Failure -> _requestError.value =
//                    "${banner.errorCode}: ${banner.errorMsg}"
//            }
//        }
//    }

//    fun getArticles(pageNum: Int) {
//        viewModelScope.launch {
//            val articles = try {
//                repository.getHomeArticles(pageNum)
//            } catch (ex: Exception) {
//                // 请求失败
//                var failure = when (ex) {
//                    is ConnectException -> HttpResponse.Failure(-1, "网络连接失败")
//                    is SocketTimeoutException -> HttpResponse.Failure(-1, "网络连接超时")
//                    //                    is HttpException
//                    else -> HttpResponse.Failure(-1, "未知错误")
//                }
//                failure
//            }
//            when (articles) {
//                is HttpResponse.Success -> _articleData.value = articles.data
//                is HttpResponse.Failure -> _requestError.value =
//                    "${articles.errorCode}: ${articles.errorMsg}"
//            }
//        }
//    }
}