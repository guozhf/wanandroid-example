package com.zephyr.baselib.utils

import android.app.Activity
import android.content.Context
import android.os.Process
import java.lang.Exception
import kotlin.system.exitProcess

/**
 * created by zephyr on 12/22/20 14 : 44
 *
 */
object AppActivityManager {

    val list: MutableList<Activity> = mutableListOf()

    fun addActivity(activity: Activity) {
        list.add(activity)
    }

    fun getTopActivity(): Activity? = if (list.size > 0) list.last() else null

    fun isActivityExit(activity: Activity): Boolean {
        if (list.size == 0) return false
        for (a in list) {
            if (a == activity) return true
        }
        return false
    }

    fun removeTopActivity() {
        if (list.size > 0) {
            val last = list.last()
            last.finish()
            list.remove(last)
        }
    }

    fun removeActivity(activity: Activity) {
        if (!isActivityExit(activity)) return
        activity.finish()
        list.remove(activity)
    }

    fun removeActivity(clazz: Class<out Activity>) {
        if (list.size == 0) return
        var target: Activity? = null
        for (activity in list) {
            if (activity::class.java == clazz) {
                target = activity
                break
            }
        }
        target?.let {
            it.finish()
            list.remove(target)
        }
    }

    fun clear() {
        if (list.size == 0) return
        for (activity in list) {
            activity.finish()
        }
        list.clear()
    }

    fun exitApp() {
        clear()
        try {
            Process.killProcess(Process.myPid())
            exitProcess(0)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
}