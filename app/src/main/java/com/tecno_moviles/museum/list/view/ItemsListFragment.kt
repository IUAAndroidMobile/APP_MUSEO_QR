package com.tecno_moviles.museum.list.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tecno_moviles.museum.base.BaseFragment
import com.tecno_moviles.museum.databinding.FragmentItemsListBinding
import com.tecno_moviles.museum.item_detail.view.ItemDetailActivity
import com.tecno_moviles.museum.list.usecase.ItemListUseCaseModel
import com.tecno_moviles.museum.list.viewModel.ItemListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ItemsListFragment() : BaseFragment(), RecyclerViewOnClickListener {

    private val itemListViewModel: ItemListViewModel by viewModel()

    private var binding: FragmentItemsListBinding? = null
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentItemsListBinding.inflate(inflater, container, false)

        recyclerView = binding!!.recyclerFavoritos
        recyclerView.layoutManager = LinearLayoutManager(view?.context)
        //recyclerView.adapter = MuseumListAdapter(favoritosList, this)





        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemListViewModel.callGetAllItems()

        itemListViewModel.bindingDelegate.setItemList.observe(viewLifecycleOwner, ::onItemListReceived)
    }

    override fun onItemClick(position: Int) {
        startActivity(Intent(activity?.applicationContext, ItemDetailActivity::class.java))

        //Toast.makeText(activity?.baseContext, "El titulo seleccionado es: ${favoritosList[position].titulo}", Toast.LENGTH_SHORT).show()
    }

    fun onItemListReceived(itemListUseCaseModel: ItemListUseCaseModel?) {
        Log.d("RECEIVED", itemListUseCaseModel?.data.toString())

        recyclerView.adapter = itemListUseCaseModel?.data?.let { MuseumListAdapter(it, this) }
    }

}