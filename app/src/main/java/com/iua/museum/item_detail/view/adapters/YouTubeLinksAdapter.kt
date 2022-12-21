package com.iua.museum.item_detail.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iua.museum.R

class YouTubeLinksAdapter(
    private val dataList: List<String>,
    private val listener: YouTubeRecyclerViewOnClickListener
) : RecyclerView.Adapter<YouTubeListRecyclerView>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YouTubeListRecyclerView {
        val row = LayoutInflater.from(parent.context).inflate(R.layout.item_view_you_tube, parent, false)
        return YouTubeListRecyclerView(row, listener)
    }

    override fun onBindViewHolder(holder: YouTubeListRecyclerView, position: Int) {
    }

    override fun getItemCount(): Int = dataList.size
}

class YouTubeListRecyclerView(itemView: View, listener: YouTubeRecyclerViewOnClickListener) :
    RecyclerView.ViewHolder(itemView) {

    init {
        itemView.setOnClickListener {
            listener.onYoutubeLinkClick(adapterPosition)
        }
    }
}

interface YouTubeRecyclerViewOnClickListener {
    fun onYoutubeLinkClick(position: Int)
}