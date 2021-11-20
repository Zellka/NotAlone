package com.example.notalone

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notalone.databinding.ActivitySplashBinding
import com.example.notalone.test.TestActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnNext.setOnClickListener {
            startActivity(Intent(this, TestActivity::class.java))
            finish()
        }
    }
}