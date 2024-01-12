package com.example.carrotmarketappreplication.activity

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import com.example.carrotmarketappreplication.data.PostInfo
import com.example.carrotmarketappreplication.databinding.ActivityDetailBinding
import com.google.android.material.snackbar.Snackbar
import java.text.DecimalFormat

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    private val post: PostInfo? by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("item_object", PostInfo::class.java)
        } else {
            intent.getParcelableExtra<PostInfo>("item_object")
        }
    }

    private val itemPosition: Int by lazy {
        intent.getIntExtra("item_index", 0)
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
        post?.image?.let { binding.ivDetailImage.setImageResource(it) }
        binding.tvDetailSeller.text = post?.userName
        binding.tvDetailPostname.text = post?.product
        binding.tvDetailAddress.text = post?.address
        binding.tvDetailPrice.text = DecimalFormat("#.###").format(post?.price).toString() + "원"
        binding.tvDetailDetail.text = post?.info


    }


    private fun setBackBtn() {
        binding.ivDetailBack.setOnClickListener {
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

}