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
import com.tecno_moviles.museum.splash.datasource.repository.ISplashRepository
import com.tecno_moviles.museum.splash.datasource.repository.SplashRepository
import com.tecno_moviles.museum.splash.datasource.service.ISplashService
import com.tecno_moviles.museum.splash.usecase.SplashUseCase
import com.tecno_moviles.museum.splash.viewModel.SplashBindingDelegate
import com.tecno_moviles.museum.splash.viewModel.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val appModule: Module = module {

    /*
    Basic region
     */
    single { providerSharedPreferences(context = get()) }
    single { providerAppPreferencesRepository(sharedPreferences = get()) }


    //end basic region

    /*
    splash region
     */
    viewModel{ SplashViewModel( splashUseCase = get(), bindingDelegate = get()) }
    factory { providerSplashBindingDelegate() }

    //Inject Use case
    single { providerSplashUseCase(get()) }

    //Inject Repository
    single<ISplashRepository> { SplashRepository(service = get()) }

    // Inject Service
    single { providerSplashService(get(named(RETROFIT_API_AUTH))) }

    /*
    end splash region
     */

    /*
    List Region
     */
    viewModel {
        ItemListViewModel(
            itemListUseCase = get(),
            bindingDelegate = get()
        )
    }
    factory { providerItemListBindingDelegate() }

    //Inject Use case
    single { providerItemListUseCase(get())}

    //Inject Repository
    single<IItemListRepository> { ItemListRepository(service = get()) }

    //Inject Service
    single { providerItemListService(get(named(RETROFIT_API_AUTH))) }
    /*
    End List Region
     */
}

fun providerSharedPreferences(context: Context): SharedPreferences {
    return context.getSharedPreferences("museum_app_shared_preferences", Context.MODE_PRIVATE)
}

fun providerAppPreferencesRepository(sharedPreferences: SharedPreferences): AppPreferencesRepository {
    return AppPreferencesRepository(sharedPreferences)
}

fun providerSplashBindingDelegate(): SplashBindingDelegate = SplashBindingDelegate()

fun providerSplashUseCase(repository: ISplashRepository) : SplashUseCase {
    return SplashUseCase(repository)
}

fun providerSplashService(retrofit: Retrofit): ISplashService {
    return retrofit.create(ISplashService::class.java)
}

fun providerItemListUseCase(repository: IItemListRepository): ItemListUseCase {
    return ItemListUseCase(repository)
}

fun providerItemListBindingDelegate(): ItemListBindingDelegate = ItemListBindingDelegate()

fun providerItemListService(retrofit: Retrofit): IItemListService {
    return retrofit.create(IItemListService::class.java)
}

