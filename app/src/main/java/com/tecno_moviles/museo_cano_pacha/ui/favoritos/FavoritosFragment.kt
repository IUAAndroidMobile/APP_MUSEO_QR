package com.tecno_moviles.museo_cano_pacha.ui.favoritos

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tecno_moviles.museo_cano_pacha.R
import com.tecno_moviles.museo_cano_pacha.resultado_qr.ResultadoActivity

class FavoritosFragment : Fragment(), RecyclerViewOnClickListener {

    private val favoritosList = mutableListOf<Favorito> ()
    lateinit var recyclerView: RecyclerView
    private lateinit var btnCorazon : View
    private lateinit var backItem : View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_favoritos, container, false)

        initFavs()

        recyclerView = view.findViewById(R.id.recyclerFavoritos)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = FavoritosListAdapter(favoritosList, this)

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

        btnCorazon = recyclerView[position].findViewById(R.id.viewCorazon)
        btnCorazon.setOnClickListener {
            if (favoritosList[position].esFav) {
                favoritosList[position].esFav = false
                it.background = resources.getDrawable(R.drawable.ic_favorite)
            } else {
                favoritosList[position].esFav = true
                it.background = resources.getDrawable(R.drawable.ic_favorite_red)
            }
        }

        backItem = recyclerView[position].findViewById(R.id.back_item)
        backItem.setOnClickListener {
            startActivity(Intent(activity?.applicationContext, ResultadoActivity::class.java))
        }

        Toast.makeText(activity?.baseContext, "El titulo seleccionado es: ${favoritosList[position].titulo}", Toast.LENGTH_SHORT).show()
    }


}