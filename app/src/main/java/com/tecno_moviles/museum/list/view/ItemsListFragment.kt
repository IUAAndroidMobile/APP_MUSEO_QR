package com.tecno_moviles.museum.list.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tecno_moviles.museum.R
import com.tecno_moviles.museum.base.BaseFragment
import com.tecno_moviles.museum.databinding.FragmentItemsListBinding
import com.tecno_moviles.museum.item_detail.ItemDetailActivity
import com.tecno_moviles.museum.list.usecase.Favorito
import com.tecno_moviles.museum.list.viewModel.ItemListViewModel

class ItemsListFragment() : BaseFragment(), RecyclerViewOnClickListener {

    private lateinit var itemListViewModel: ItemListViewModel

    private var binding: FragmentItemsListBinding? = null
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentItemsListBinding.inflate(inflater, container, false)
        initFavs()

        recyclerView = binding!!.recyclerFavoritos
        recyclerView.layoutManager = LinearLayoutManager(view?.context)
        //recyclerView.adapter = MuseumListAdapter(favoritosList, this)

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemListViewModel = ViewModelProvider(this).get(ItemListViewModel::class.java)

    }

    private fun initFavs () {
        // Duda: cambiar por uri o por id drawable segun lo que devuelva el servidor
        /**favoritosList.add(Favorito("mona", "La Giaconda", "soy una descripción", true))
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
        favoritosList.add(Favorito("grito", "El grito", "soy una descripción 3", true))**/

    }

    override fun onItemClick(position: Int) {
        startActivity(Intent(activity?.applicationContext, ItemDetailActivity::class.java))

        //Toast.makeText(activity?.baseContext, "El titulo seleccionado es: ${favoritosList[position].titulo}", Toast.LENGTH_SHORT).show()
    }


}