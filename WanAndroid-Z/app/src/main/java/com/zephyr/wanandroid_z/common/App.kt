package com.zephyr.wanandroid_z.common

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.zephyr.baselib.utils.AppActivityManager
import com.zephyr.baselib.utils.AppCrashHandler

/**
 * created by zephyr on 2020/12/2 14 : 57
 *
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = this
        AppCrashHandler.getInstance().init(this)
        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                AppActivityManager.addActivity(activity)
            }

            override fun onActivityStarted(activity: Activity) {
            }

            override fun onActivityResumed(activity: Activity) {
            }

            override fun onActivityPaused(activity: Activity) {
            }

            override fun onActivityStopped(activity: Activity) {
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
            }

            override fun onActivityDestroyed(activity: Activity) {
                AppActivityManager.removeActivity(activity)
            }

        })
    }

    companion object {
        lateinit var appContext: App
            private set
    }
}