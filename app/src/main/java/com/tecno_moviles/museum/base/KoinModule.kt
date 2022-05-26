package com.tecno_moviles.museum.base

import com.tecno_moviles.museum.list.datasource.repository.IItemListRepository
import com.tecno_moviles.museum.list.datasource.repository.ItemListRepository
import com.tecno_moviles.museum.list.datasource.service.IItemListService
import com.tecno_moviles.museum.list.viewModel.ItemListBindingDelegate
import com.tecno_moviles.museum.list.viewModel.ItemListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit

val appModule: Module = module {

    viewModel { ItemListViewModel(itemListUseCase = get(), bindingDelegate = get(), presenterDelegate = get())}
    factory { providerItemListBindingDelegate() }

    //Inject Repository
    single<IItemListRepository> { ItemListRepository(service = get()) }

    //Inject Service
    //single { providerItemListService() }

}

fun providerItemListBindingDelegate(): ItemListBindingDelegate = ItemListBindingDelegate()

fun providerItemListService(retrofit: Retrofit): IItemListService {
    return retrofit.create(IItemListService::class.java)
}