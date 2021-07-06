package com.zephyr.baselib.data

/**
 * created by zephyr on 2020/12/9 13 : 48
 *
 */
data class TabEntity(
    val children: List<TabEntity>?,
    val id: Int,
    val name: String?,
    val order: Int,
    val parentChapterId: Int,
    val isUserControlSetTop: Boolean,
    val visible: Int
)
