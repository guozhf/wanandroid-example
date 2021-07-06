package com.zephyr.wanandroid_z.data

import com.zephyr.baselib.api.HttpClientFactory
import com.zephyr.baselib.api.HttpResponse
import com.zephyr.baselib.base.BaseRepository
import com.zephyr.baselib.data.TabEntity
import com.zephyr.http.exception.ServerException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


/**
 * created by zephyr on 2020/12/2 15 : 20
 *
 */
class HomeRepository : BaseRepository() {

//    suspend fun getBanner(): HttpResponse<List<BannerEntity>> {
//        val response = withContext(Dispatchers.IO) {
//            HttpClient.request().getHomeBanner()
//        }
//
//        return if (response.errorCode == 0) {
//            HttpResponse.Success(response.data)
//        } else {
//            HttpResponse.Failure(response.errorCode, response.errorMsg)
//        }
//    }

//    suspend fun getHomeArticles(pageNum: Int = 0): HttpResponse<List<ArticleEntity>> {
//        val response = withContext(Dispatchers.IO) {
//            HttpClient.request().getHomeArticles(pageNum)
//        }
//
//        return if (response.errorCode == 0) {
//            HttpResponse.Success(response.data?.datas) // TODO 先暂时这么处理，加了下拉刷新以后再处理别的参数
//        } else {
//            HttpResponse.Failure(response.errorCode, response.errorMsg)
//        }
//    }

    suspend fun getTabs(): HttpResponse<List<TabEntity>>{
        val response = withContext(Dispatchers.IO) {
            HttpClientFactory.request().getTabs()
        }

        if (response.errorCode == 0) return HttpResponse.Success(response.data)
        throw ServerException(response.errorCode, response.errorMsg)
    }
}