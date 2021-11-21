package com.example.notalone.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import com.example.notalone.R

class QuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        supportActionBar?.hide()

        findViewById<Toolbar>(R.id.tol).setNavigationOnClickListener {
            finish()
        }
    }
}