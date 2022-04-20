package com.tecno_moviles.museo_cano_pacha.ui.favoritos

import android.app.Activity
import android.content.ContentValues
import android.content.Context
import android.content.pm.PackageInfo
import android.content.res.Resources
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.tecno_moviles.museo_cano_pacha.R
import java.io.File

class FavoritosListAdapter (private val data: List<Favorito>, private val listener: RecyclerViewOnClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder> () {

    lateinit var aux : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val row = LayoutInflater.from(parent.context).inflate(R.layout.item_view_favorito, parent, false)
        aux = parent.context
        return FavoritosListViewHolder(row, listener)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val favo = data.get(position)

        (holder as FavoritosListViewHolder).imgFav.setImageResource(aux.resources.getIdentifier(favo.imagenNombre, "drawable", aux.packageName))
        holder.tituloFav.text = favo.titulo
        holder.descipFavo.text = favo.descrip
        if (favo.esFav) holder.corazon.background = aux.getDrawable(R.drawable.ic_favorite_red) else holder.corazon.background = aux.getDrawable(R.drawable.ic_favorite)
    }

    override fun getItemCount(): Int = data.size

}

class FavoritosListViewHolder (itemView: View, listener: RecyclerViewOnClickListener) : RecyclerView.ViewHolder(itemView) {
    var imgFav : ImageView = itemView.findViewById(R.id.imgItemFavo)
    var tituloFav : TextView = itemView.findViewById(R.id.tituloItemFavo)
    var descipFavo : TextView = itemView.findViewById(R.id.descripItemFavo)
    var corazon : View = itemView.findViewById(R.id.viewCorazon)

    init {
        itemView.setOnClickListener {
            listener.onItemClick(adapterPosition)
        }
    }
}

interface RecyclerViewOnClickListener {
    fun onItemClick (position: Int)
}