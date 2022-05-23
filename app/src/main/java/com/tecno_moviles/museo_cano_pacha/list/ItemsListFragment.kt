package com.tecno_moviles.museo_cano_pacha.list

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tecno_moviles.museo_cano_pacha.R
import com.tecno_moviles.museo_cano_pacha.item_detail.ItemDetailActivity
import com.tecno_moviles.museo_cano_pacha.list.data.Favorito

class ItemsListFragment : Fragment(), RecyclerViewOnClickListener {

    private val favoritosList = mutableListOf<Favorito> ()
    lateinit var recyclerView: RecyclerView
    private lateinit var btnCorazon : View
    private lateinit var backItem : View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_items_list, container, false)

        initFavs()

        recyclerView = view.findViewById(R.id.recyclerFavoritos)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = MuseumListAdapter(favoritosList, this)

        return view
    }

    private fun initFavs () {
        // Duda: cambiar por uri o por id drawable segun lo que devuelva el servidor
        favoritosList.add(Favorito("mona", "La Giaconda", "soy una descripción", true))
        favoritosList.add(Favorito("dedos", "Dedos dedosos", "soy una descripción 2", false))
        favoritosList.add(Favorito("grito", "El grito", "soy una descripción 3", true))
        favoritosList.add(Favorito("mona", "La Giaconda", "soy una descripción", true))
        favoritosList.add(Favorito("dedos", "Dedos dedosos", "soy una descripción 2", false))
        favoritosList.add(Favorito("grito", "El grito", "soy una descripción 3", true))
        favoritosList.add(Favorito("mona", "La Giaconda", "soy una descripción", true))
        favoritosList.add(Favorito("dedos", "Dedos dedosos", "soy una descripción 2", false))
        favoritosList.add(Favorito("grito", "El grito", "soy una descripción 3", true))
        favoritosList.add(Favorito("mona", "La Giaconda", "soy una descripción", true))
        favoritosList.add(Favorito("dedos", "Dedos dedosos", "soy una descripción 2", false))
        favoritosList.add(Favorito("grito", "El grito", "soy una descripción 3", true))
        favoritosList.add(Favorito("mona", "La Giaconda", "soy una descripción", true))
        favoritosList.add(Favorito("dedos", "Dedos dedosos", "soy una descripción 2", false))
        favoritosList.add(Favorito("grito", "El grito", "soy una descripción 3", true))

    }

    override fun onItemClick(position: Int) {
        startActivity(Intent(activity?.applicationContext, ItemDetailActivity::class.java))

        //Toast.makeText(activity?.baseContext, "El titulo seleccionado es: ${favoritosList[position].titulo}", Toast.LENGTH_SHORT).show()
    }


}