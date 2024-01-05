package com.example.carrotmarketappreplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carrotmarketappreplication.R
import com.example.carrotmarketappreplication.adapter.PostAdapter
import com.example.carrotmarketappreplication.data.PostDatabase.formDummyData
import com.example.carrotmarketappreplication.data.PostDatabase.totalPostData
import com.example.carrotmarketappreplication.data.PostInfo
import com.example.carrotmarketappreplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {




    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {

        formDummyData()


        val adapter = PostAdapter(totalPostData)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        adapter.itemClick = object : PostAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                TODO("Not yet implemented")
            }
        }
    }
}