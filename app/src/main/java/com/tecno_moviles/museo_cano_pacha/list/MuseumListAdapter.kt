package com.tecno_moviles.museo_cano_pacha.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tecno_moviles.museo_cano_pacha.R
import com.tecno_moviles.museo_cano_pacha.list.data.Favorito

class MuseumListAdapter (private val data: List<Favorito>, private val listener: RecyclerViewOnClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder> () {

    lateinit var context : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val row = LayoutInflater.from(parent.context).inflate(R.layout.item_view_museum, parent, false)
        context = parent.context
        return MuseumListViewHolder(row, listener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = data[position]
        (holder as MuseumListViewHolder).imgFav.setImageResource(context.resources.getIdentifier(item.imagenNombre, "drawable", context.packageName))
        holder.tituloFav.text = item.titulo
        holder.descipFavo.text = item.descrip
    }

    override fun getItemCount(): Int = data.size
}

class MuseumListViewHolder (itemView: View, listener: RecyclerViewOnClickListener) : RecyclerView.ViewHolder(itemView) {
    var imgFav : ImageView = itemView.findViewById(R.id.imgItemFavo)
    var tituloFav : TextView = itemView.findViewById(R.id.tituloItemFavo)
    var descipFavo : TextView = itemView.findViewById(R.id.descripItemFavo)

    init {
        itemView.setOnClickListener {
            listener.onItemClick(adapterPosition)
        }
    }
}

interface RecyclerViewOnClickListener {
    fun onItemClick (position: Int)
}