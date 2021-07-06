package com.zephyr.baselib.base

import androidx.appcompat.app.AppCompatActivity
import com.zephyr.base_ui.UIOperateImpl

/**
 * created by zephyr on 2020/12/9 09 : 57
 *
 */
abstract class BaseActivity : AppCompatActivity() {

    protected val baseUIOperate: UIOperateImpl by lazy { UIOperateImpl.create(this) }
}