package com.agening.di

import com.agening.data.repository.UserRepositoryImpl
import com.agening.data.storage.UserStorage
import com.agening.data.storage.sharedrefs.SharedPrefUserStorage
import com.agening.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {
    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }
    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }
}