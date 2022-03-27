package com.dolcegusto.nescafe.app.di

import com.dolcegusto.nescafe.features.profile.data.repository.ProfileRepository
import com.dolcegusto.nescafe.features.profile.data.repository.ProfileRepositoryImpl
import com.dolcegusto.nescafe.features.profile.ui.viewmodel.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<ProfileRepository> { ProfileRepositoryImpl() }

    viewModel { ProfileViewModel(get()) }
}