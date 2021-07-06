package com.zephyr.wanandroid_z.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.zephyr.wanandroid_z.R
import com.zephyr.wanandroid_z.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Handler().postDelayed({
            roll()
        }, 2000)
    }

    private fun roll() {
        val animation = AnimationUtils.loadAnimation(this, R.anim.anim_roll_and_accelerate)
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationEnd(p0: Animation?) {
                MainActivity.start(this@SplashActivity)
                finish()
            }

            override fun onAnimationRepeat(p0: Animation?) {
            }

            override fun onAnimationStart(p0: Animation?) {
            }
        })
        binding.ivAndroid.startAnimation(animation)
    }

}