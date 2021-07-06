package com.zephyr.wanandroid_z.ui.search

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zephyr.baselib.base.BaseActivity
import com.zephyr.wanandroid_z.databinding.ActivitySearchBinding
import com.zephyr.wanandroid_z.ui.login.LoginActivity

class SearchActivity : BaseActivity() {
    private lateinit var binding: ActivitySearchBinding

    companion object {
        fun start(activity: Activity) {
            val intent = Intent(activity, SearchActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvTest.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}