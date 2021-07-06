package com.zephyr.baselib.data

/**
 * created by zephyr on 2020/12/7 16 : 21
 * apkLink :
 * audit : 1
 * author :
 * canEdit : false
 * chapterId : 478
 * chapterName : DataBinding
 * collect : false
 * courseId : 13
 * desc :
 * descMd :
 * envelopePic :
 * fresh : true
 * id : 16303
 * link : https://openxu.blog.csdn.net/article/details/110393163
 * niceDate : 4小时前
 * niceShareDate : 1天前
 * origin :
 * prefix :
 * projectLink :
 * publishTime : 1607058804000
 * realSuperChapterId : 422
 * selfVisible : 0
 * shareDate : 1606977961000
 * shareUser : 深红骑士
 * superChapterId : 423
 * superChapterName : Jetpack
 * tags : []
 * title : DataBinding为null？模块化开发中的DataBinding你需要注意了
 * type : 0
 * userId : 29303
 * visible : 1
 * zan : 0
 */
data class ArticleEntity(
    var apkLink: String? = null,
    var audit: Int = 0,
    var author: String? = null,
    var isCanEdit: Boolean = false,
    var chapterId: Int = 0,
    var chapterName: String? = null,
    var isCollect: Boolean = false,
    var courseId: Int = 0,
    var desc: String? = null,
    var descMd: String? = null,
    var envelopePic: String? = null,
    var isFresh: Boolean = false,
    var id: Int = 0,
    var link: String? = null,
    var niceDate: String? = null,
    var niceShareDate: String? = null,
    var origin: String? = null,
    var prefix: String? = null,
    var projectLink: String? = null,
    var publishTime: Long = 0,
    var realSuperChapterId: Int = 0,
    var selfVisible: Int = 0,
    var shareDate: Long = 0,
    var shareUser: String? = null,
    var superChapterId: Int = 0,
    var superChapterName: String? = null,
    var title: String? = null,
    var type: Int = 0,
    var userId: Int = 0,
    var visible: Int = 0,
    var zan: Int = 0,
    var tags: List<ArticleTag>? = null
)

data class ArticleTag(val name: String, val url: String)
//
//{
//    "name": "本站发布",
//    "url": "/article/list/0?cid=440"
//}