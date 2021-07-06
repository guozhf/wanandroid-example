package com.zephyr.baselib.data

/**
 * created by zephyr on 2020/12/7 16 : 17
 *
 */
data class ArticleListEntity(
    val curPage: Int,
    var offset: Int,
    val over: Boolean,
    val pageCount: Int,
    val size: Int,
    val total: Int,
    val datas: List<ArticleEntity>?
)
