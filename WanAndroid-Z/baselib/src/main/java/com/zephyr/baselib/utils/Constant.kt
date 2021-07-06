package com.zephyr.baselib.utils

/**
 * created by zephyr on 2020/12/4 17 : 02
 *
 */
object Constant {
    const val COMMON_TIME_OUT = 15_000L

    // 去除一些使用频率低或者内容太过庞杂或者工具性太强的tab
    val EXCLUDE_TABS_LIST = listOf<String>(
        "硬件模块", "项目必备", "推荐网站", "导航主Tab", "开源项目主Tab", "TV相关", "开发API", "内推", "公众号",
        "问答", "视频", "翻译", "设计Tab", "端智能"
    )
}