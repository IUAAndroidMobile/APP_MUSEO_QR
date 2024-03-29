package com.iua.museum.base

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.iua.museum.home.viewModel.HomeBindingDelegate
import com.iua.museum.home.viewModel.HomeViewModel
import com.iua.museum.item_detail.datasource.repository.IItemDetailRepository
import com.iua.museum.item_detail.datasource.repository.ItemDetailRepository
import com.iua.museum.item_detail.datasource.service.IItemDetailService
import com.iua.museum.item_detail.usecase.ItemDetailUseCase
import com.iua.museum.item_detail.viewModel.ItemDetailBindingDelegate
import com.iua.museum.item_detail.viewModel.ItemDetailViewModel
import com.iua.museum.list.datasource.repository.IItemListRepository
import com.iua.museum.list.datasource.repository.ItemListRepository
import com.iua.museum.list.datasource.service.IItemListService
import com.iua.museum.list.usecase.ItemListUseCase
import com.iua.museum.list.viewModel.ItemListBindingDelegate
import com.iua.museum.list.viewModel.ItemListViewModel
import com.iua.museum.preferences.AppPreferencesRepository
import com.iua.museum.preferences.IAppPreferencesRepository
import com.iua.museum.splash.datasource.repository.IAppLoginRepository
import com.iua.museum.splash.datasource.repository.AppLoginRepository
import com.iua.museum.splash.datasource.service.ILoginService
import com.iua.museum.splash.usecase.ShowTermsAndConditionsScreenUseCase
import com.iua.museum.splash.usecase.ShowWelcomeScreenUseCase
import com.iua.museum.splash.usecase.AppLoginUseCase
import com.iua.museum.splash.viewModel.SplashBindingDelegate
import com.iua.museum.splash.viewModel.SplashViewModel
import com.iua.museum.terms_conditions.usecase.SignTermsAndConditionsUseCase
import com.iua.museum.terms_conditions.viewModel.TermsAndConditionsBindingDelegate
import com.iua.museum.terms_conditions.viewModel.TermsAndConditionsViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val appModule: Module = module {

    //*** Basic region ***
    single { providerSharedPreferences(androidApplication()) }
    single { providerAppPreferencesRepository(sharedPreferences = get()) }
    //*** end basic region ***

    //*** Splash region ***
    viewModel{ SplashViewModel(
        appLoginUseCase = get(),
        showTermsAndConditionsScreenUseCase = get(),
        showWelcomeScreenUseCase = get(),
        splashBindingDelegate = get()) }
    factory { providerSplashBindingDelegate() }

    //Inject Use case
    single { providerSplashUseCase(get()) }
    single { providerShowTermsAndConditionsUseCase(get()) }
    single { providerShowWelcomeScreenUseCase(get()) }

    //Inject Repository
    single<IAppLoginRepository> { AppLoginRepository(service = get()) }

    // Inject Service
    single { providerSplashService(get(named(RETROFIT_API_AUTH))) }

    //*** end splash region ***
    //*** Home region ***
    viewModel {
        HomeViewModel(
            homeBindingDelegate = get()
        )
    }
    factory { providerHomeBindingDelegate() }

    //*** end Home Region ***


    //*** Terms And Conditions Region ***
    viewModel {
        TermsAndConditionsViewModel(
            signTermsAndConditionsUseCase = get(),
            showWelcomeScreenUseCase = get(),
            bindingDelegate = get()
        ) }
    factory { providerTermsAndConditionsBindingDelegate() }

    // Inject Use Case
    single { providerSignTermsAndConditionsUseCase(get()) }

    // **** End Terms And Conditions Region ***


    //*** List Region ***
    viewModel {
        ItemListViewModel(
            itemListUseCase = get(),
            itemListBindingDelegate = get()
        )
    }
    factory { providerItemListBindingDelegate() }

    //Inject Use case
    single { providerItemListUseCase(get())}

    //Inject Repository
    single<IItemListRepository> { ItemListRepository(service = get((named("ApiPrivate")))) }

    //Inject Service
    single(named("ApiPrivate"))  { providerItemListService(get(named(RETROFIT_API_AUTH))) }

    // *** End List Region ***


    // *** Item Detail Region ***
    viewModel { ItemDetailViewModel( itemDetailUseCase = get(), bindingDelegate = get())}
    factory { providerItemDetailBindingDelegate() }

    //Inject Use Case
    single { providerItemDetailUseCase(get()) }

    //Inject Repository
    single<IItemDetailRepository> { ItemDetailRepository(service = get()) }

    //Inject Service
    single { providerItemDetailService(get(named(RETROFIT_API_AUTH))) }


    // *** End Item detail region ***
}

fun providerSharedPreferences(androidApplication: Application): SharedPreferences {
    return androidApplication.getSharedPreferences("museum_app_shared_preferences", Context.MODE_PRIVATE)
}

fun providerAppPreferencesRepository(sharedPreferences: SharedPreferences): IAppPreferencesRepository {
    return AppPreferencesRepository(sharedPreferences)
}

fun providerSplashBindingDelegate(): SplashBindingDelegate {
    return SplashBindingDelegate()
}

fun providerSplashUseCase(repository: IAppLoginRepository) : AppLoginUseCase {
    return AppLoginUseCase(repository)
}

fun providerShowTermsAndConditionsUseCase(repository: IAppPreferencesRepository): ShowTermsAndConditionsScreenUseCase {
    return ShowTermsAndConditionsScreenUseCase(repository)
}

fun providerShowWelcomeScreenUseCase(repository: IAppPreferencesRepository): ShowWelcomeScreenUseCase {
    return ShowWelcomeScreenUseCase(repository)
}

fun providerSplashService(retrofit: Retrofit): ILoginService {
    return retrofit.create(ILoginService::class.java)
}

fun providerHomeBindingDelegate() : HomeBindingDelegate {
    return HomeBindingDelegate()
}

fun providerTermsAndConditionsBindingDelegate() : TermsAndConditionsBindingDelegate {
    return TermsAndConditionsBindingDelegate()
}

fun providerSignTermsAndConditionsUseCase(repository: IAppPreferencesRepository) : SignTermsAndConditionsUseCase {
    return SignTermsAndConditionsUseCase(repository)
}

fun providerItemListUseCase(repository: IItemListRepository): ItemListUseCase {
    return ItemListUseCase(repository)
}

fun providerItemListBindingDelegate(): ItemListBindingDelegate {
    return ItemListBindingDelegate()
}

fun providerItemListService(retrofit: Retrofit): IItemListService {
    return retrofit.create(IItemListService::class.java)
}

fun providerItemDetailBindingDelegate(): ItemDetailBindingDelegate = ItemDetailBindingDelegate()

fun providerItemDetailUseCase(repository: IItemDetailRepository): ItemDetailUseCase {
    return ItemDetailUseCase(repository)
}

fun providerItemDetailService(retrofit: Retrofit): IItemDetailService {
    return retrofit.create(IItemDetailService::class.java)
}

