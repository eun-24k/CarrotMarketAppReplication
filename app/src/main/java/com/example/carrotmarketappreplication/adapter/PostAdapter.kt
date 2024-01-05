package com.example.carrotmarketappreplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carrotmarketappreplication.data.PostInfo
import com.example.carrotmarketappreplication.databinding.PostRecyclerviewBinding

class PostAdapter(val mItems: ArrayList<PostInfo>) : RecyclerView.Adapter<PostAdapter.Holder>() {

    interface ItemClick {
        fun onClick(view : View, position: Int)
    }

    var itemClick : ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = PostRecyclerviewBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return Holder(binding)
    }
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position)
        }
        holder.postImage.setImageResource(mItems[position].image)
        holder.product.text = mItems[position].product
        holder.address.text = mItems[position].address
        holder.price.text = mItems[position].price.toString()
        holder.commentCount.text = mItems[position].comments.toString()
        holder.likesCount.text = mItems[position].likes.toString()
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    inner class Holder(val binding: PostRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
        val postImage = binding.postImage
        val product = binding.tvProduct
        val address = binding.tvAddress
        val price = binding.tvPrice
        val likesCount = binding.tvLikesCount
        val commentCount = binding.tvCommentCount
    }
}