package com.example.carrotmarketappreplication.data



data class PostInfo(
    var index: Int,
    var image: Int,
    var product: String,
    var info: String,
    var userName: String,
    var price: Int,
    var address: String,
    var likes: Int,
    var comments: Int
)