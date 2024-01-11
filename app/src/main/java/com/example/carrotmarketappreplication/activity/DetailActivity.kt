package com.example.carrotmarketappreplication.activity

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.carrotmarketappreplication.data.PostInfo
import com.example.carrotmarketappreplication.databinding.ActivityDetailBinding

@Suppress("DEPRECATION")
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    private val post = intent.getParcelableExtra<PostInfo>("data")

    companion object{
        fun newIntent(context: Context, post: PostInfo): Intent = Intent(context, DetailActivity::class.java).apply {
            putExtra("data", post)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init() {

        setInfo()

        setBackBtn()
    }

    private fun setInfo() {
        if(post == null){
            MainActivity()
        } else {
            binding.ivDetailImage.setImageResource(post!!.image)
            binding.tvDetailSeller.text = post.userName
            binding.tvDetailPostname.text = post.product
            binding.tvDetailAddress.text = post.address
            binding.tvDetailPrice.text = post.price.toString()
            binding.tvDetailDetail.text = post.info
        }
    }


    private fun setBackBtn() {
        binding.ivDetailBack.setOnClickListener {
            finish()
        }
    }
}