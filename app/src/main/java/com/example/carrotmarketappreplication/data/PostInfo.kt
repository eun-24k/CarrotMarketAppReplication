package com.example.carrotmarketappreplication.data

import org.apache.poi.ss.usermodel.Cell


data class PostInfo(
    var index: Int,
    var image: String,
    var product: String,
    var info: String,
    var userName: String,
    var price: Int,
    var address: String,
    var likes: Int,
    var comments: Int
)