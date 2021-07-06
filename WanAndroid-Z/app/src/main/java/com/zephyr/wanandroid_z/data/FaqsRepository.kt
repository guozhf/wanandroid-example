package com.zephyr.wanandroid_z.data

import com.zephyr.baselib.api.HttpClientFactory
import com.zephyr.baselib.api.HttpResponse
import com.zephyr.baselib.base.BaseRepository
import com.zephyr.baselib.data.ArticleEntity
import com.zephyr.http.exception.ServerException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * created by zephyr on 12/17/20 14 : 36
 *
 */
class FaqsRepository : BaseRepository() {

    suspend fun getFaqs(pageNum: Int): HttpResponse<List<ArticleEntity>> {
        val response = withContext(Dispatchers.IO) {
            HttpClientFactory.request().getFaqs(pageNum)
        }
        if (response.errorCode == 0) return HttpResponse.Success(response.data?.datas)
        throw ServerException(response.errorCode, response.errorMsg)
    }
}