package com.dolcegusto.nescafe.app.di

import com.dolcegusto.nescafe.app.data.repository.UserRepository
import com.dolcegusto.nescafe.app.data.repository.UserRepositoryImpl
import com.dolcegusto.nescafe.features.profile.data.repository.ProfileRepository
import com.dolcegusto.nescafe.features.profile.data.repository.ProfileRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesProfileRepository() : ProfileRepository {
        return ProfileRepositoryImpl()
    }

    @Provides
    @Singleton
    fun providesUserRepository() : UserRepository {
        return UserRepositoryImpl()
    }
}

