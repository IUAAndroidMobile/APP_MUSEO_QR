package com.iua.museum.list.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.iua.museum.base.BaseFragment
import com.iua.museum.base.BaseViewModel
import com.iua.museum.databinding.FragmentItemsListBinding
import com.iua.museum.item_detail.view.ItemDetailActivity
import com.iua.museum.list.usecase.ItemListUseCaseModel
import com.iua.museum.list.viewModel.ItemListViewModel
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

        return binding!!.root
    }

    override fun getViewModel(): BaseViewModel = itemListViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemListViewModel.callGetAllItems()

        itemListViewModel.itemListBindingDelegate.setItemList.observe(viewLifecycleOwner, ::onItemListReceived)
    }

    override fun onItemClick(position: Int) {
        startActivity(Intent(activity?.applicationContext, ItemDetailActivity::class.java))

        //Toast.makeText(activity?.baseContext, "El titulo seleccionado es: ${favoritosList[position].titulo}", Toast.LENGTH_SHORT).show()
    }

    private fun onItemListReceived(itemListUseCaseModel: ItemListUseCaseModel?) {
        Log.d("RECEIVED", itemListUseCaseModel?.data.toString())

        recyclerView.adapter = itemListUseCaseModel?.data?.let { MuseumListAdapter(it, this) }
    }

}