package com.example.notalone.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notalone.databinding.ActivityTestBinding

class TestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTestBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


}