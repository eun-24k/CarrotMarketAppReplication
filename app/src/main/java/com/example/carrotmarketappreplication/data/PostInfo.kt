package com.example.carrotmarketappreplication.data

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
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
) : Parcelable {
}

