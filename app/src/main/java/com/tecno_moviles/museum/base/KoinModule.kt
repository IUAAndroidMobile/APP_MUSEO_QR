package com.tecno_moviles.museum.base

import android.content.Context
import android.content.SharedPreferences
import com.tecno_moviles.museum.list.datasource.repository.IItemListRepository
import com.tecno_moviles.museum.list.datasource.repository.ItemListRepository
import com.tecno_moviles.museum.list.datasource.service.IItemListService
import com.tecno_moviles.museum.list.usecase.ItemListUseCase
import com.tecno_moviles.museum.list.viewModel.ItemListBindingDelegate
import com.tecno_moviles.museum.list.viewModel.ItemListViewModel
import com.tecno_moviles.museum.preferences.AppPreferencesRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val appModule: Module = module {

    //Basic region
    single { providerSharedPreferences(context = get()) }
    single { providerAppPreferencesRepository(sharedPreferences = get()) }


    //end basic region

    //List Region
    viewModel {
        ItemListViewModel(
            itemListUseCase = get(),
            bindingDelegate = get()
        )
    }
    factory { providerItemListBindingDelegate() }

    //Inject Repository
    single<IItemListRepository> { ItemListRepository(service = get()) }

    //Inject Use case
    single { providerItemListUseCase(get())}

    //Inject Service
    single { providerItemListService(get(named(RETROFIT_API_AUTH))) }
    //End List Region

}

fun providerSharedPreferences(context: Context): SharedPreferences {
    return context.getSharedPreferences("museum_app_shared_preferences", Context.MODE_PRIVATE)
}

fun providerAppPreferencesRepository(sharedPreferences: SharedPreferences): AppPreferencesRepository {
    return AppPreferencesRepository(sharedPreferences)
}

fun providerItemListUseCase(repository: IItemListRepository): ItemListUseCase {
    return ItemListUseCase(repository)
}

fun providerItemListBindingDelegate(): ItemListBindingDelegate = ItemListBindingDelegate()

fun providerItemListService(retrofit: Retrofit): IItemListService {
    return retrofit.create(IItemListService::class.java)
}

