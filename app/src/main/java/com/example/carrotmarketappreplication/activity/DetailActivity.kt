package com.example.carrotmarketappreplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carrotmarketappreplication.R
import com.example.carrotmarketappreplication.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {

    }

}