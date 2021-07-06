package com.zephyr.baselib.api

import com.zephyr.baselib.data.ArticleListEntity
import com.zephyr.baselib.data.BannerEntity
import com.zephyr.baselib.data.TabEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * created by zephyr on 2020/12/2 11 : 32
 *
 */
interface Api {
    companion object {
        const val BASE_URL = "https://www.wanandroid.com/"
    }

    @GET("banner/json")
    suspend fun getHomeBanner(): ApiResponse<List<BannerEntity>>

//    @GET("article/list/{pageNum}/json")
//    suspend fun getHomeArticles(@Path("pageNum") pageNum: Int): ApiResponse<ApiListData<HomeArticleEntity>>

    @GET("article/list/{pageNum}/json")
    suspend fun getHomeArticles(@Path("pageNum") pageNum: Int): ApiResponse<ArticleListEntity>

    @GET("tree/json")
    suspend fun getTabs(): ApiResponse<List<TabEntity>>

    @GET("wenda/list/{pageNum}/json")
    suspend fun getFaqs(@Path("pageNum") pageNum: Int = 1): ApiResponse<ArticleListEntity>
}