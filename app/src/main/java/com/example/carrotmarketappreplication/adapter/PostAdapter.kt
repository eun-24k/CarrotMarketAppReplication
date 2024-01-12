package com.example.carrotmarketappreplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carrotmarketappreplication.data.PostDatabase.totalPostData
import com.example.carrotmarketappreplication.data.PostInfo
import com.example.carrotmarketappreplication.databinding.PostRecyclerviewBinding
import java.text.DecimalFormat



class PostAdapter(private val mItems: ArrayList<PostInfo>) : RecyclerView.Adapter<PostAdapter.Holder>() {


    interface ItemClick {
        fun onClick(view : View, position: Int)
    }
    interface ItemLongClick {
        fun onLongClick(view : View, position : Int)
    }

    var itemClick : ItemClick? = null
    var itemLongClick : ItemLongClick? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = PostRecyclerviewBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return Holder(binding)
    }
    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder.apply {
            itemView.setOnClickListener {
                itemClick?.onClick(it,position)
            }
            with(totalPostData[position]) {
                val dec = DecimalFormat("#,###")

                postImage.setImageResource(this.image)
                holder.product.text = this.product
                holder.address.text = this.address
                holder.price.text = dec.format(this.price).toString() + "원"
                holder.commentCount.text = this.comments.toString()
                holder.likesCount.text = this.likes.toString()
            }
        }

        holder.itemView.setOnLongClickListener() OnLongClickListener@{
            itemLongClick?.onLongClick(it, position)
            return@OnLongClickListener true
        }


    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    inner class Holder(binding: PostRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
        val postImage = binding.postImage
        val product = binding.tvProduct
        val address = binding.tvAddress
        val price = binding.tvPrice
        val likesCount = binding.tvLikesCount
        val commentCount = binding.tvCommentCount
    }


}