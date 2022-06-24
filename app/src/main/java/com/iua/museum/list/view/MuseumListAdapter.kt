package com.iua.museum.list.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.iua.museum.R
import com.iua.museum.list.usecase.MuseumItemList

class MuseumListAdapter(
    val dataList: List<MuseumItemList>,
    private val listener: RecyclerViewOnClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val row =
            LayoutInflater.from(parent.context).inflate(R.layout.item_view_museum, parent, false)
        context = parent.context
        return MuseumListViewHolder(row, listener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = dataList[position]
        (holder as MuseumListViewHolder).imgFav.setImageResource(
            context.resources.getIdentifier(
                item.mainImageURL,
                "drawable",
                context.packageName
            )
        )
        holder.tituloFav.text = item.title
        holder.descipFavo.text = item.introduction

        Glide
            .with(holder.itemView)
            .load(item.mainImageURL)
            .centerCrop()
            .into(holder.imgFav)
    }

    override fun getItemCount(): Int = dataList.size
}

class MuseumListViewHolder(itemView: View, listener: RecyclerViewOnClickListener) :
    RecyclerView.ViewHolder(itemView) {
    var imgFav: ImageView = itemView.findViewById(R.id.imgItemFavo)
    var tituloFav: TextView = itemView.findViewById(R.id.tituloItemFavo)
    var descipFavo: TextView = itemView.findViewById(R.id.descripItemFavo)

    init {
        itemView.setOnClickListener {
            listener.onItemClick(adapterPosition)
        }
    }
}

interface RecyclerViewOnClickListener {
    fun onItemClick(position: Int)
}