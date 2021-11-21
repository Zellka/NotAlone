package com.example.notalone.services

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notalone.R
import com.example.notalone.adapter.ClickListener
import com.example.notalone.adapter.ClickListener2
import com.example.notalone.adapter.ProviderAdapter
import com.example.notalone.adapter.ServicesAdapter
import com.example.notalone.entity.Provider
import com.example.notalone.entity.Services

class ServicesActivity : AppCompatActivity() , ClickListener2 {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services)
        supportActionBar?.hide()

        findViewById<Toolbar>(R.id.tol).setNavigationOnClickListener {
            finish()
        }

        val providers = listOf<Provider>(
            Provider("Dog grooming", "Designer haircut of dogs of all breeds. We do our best for you and will be glad to see you and your pets. We do not work on weekends","Mannerheimintie 20","10-100"),
            Provider("Cat Cafe", "Do you want to have a delicious snack in a nice place in the company of our furry cats ? We welcome everyone !","Aleksanterinkatu 52","from 5"),
            Provider("Pet Store", "A small pet store that works to bring you and your pets great happiness!","Mannerheimintie 20","different"),
            Provider("Exhibition of parrots", "A unique exhibition of parrots collected from all over the world! Come to see colorful birds and improve your mood","Mannerheimintie 20","10"),
        )

        findViewById<RecyclerView>(R.id.res).layoutManager = LinearLayoutManager(this)
        findViewById<RecyclerView>(R.id.res).adapter = ProviderAdapter(providers, this)
    }

    override fun showProvider(book: Provider) {
        startActivity(Intent(this, PostActivity::class.java))
    }
}