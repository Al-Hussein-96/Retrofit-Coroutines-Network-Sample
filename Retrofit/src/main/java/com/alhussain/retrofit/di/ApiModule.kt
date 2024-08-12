package com.alhussain.retrofit.di

import com.alhussain.retrofit.RetrofitNetwork
import com.alhussain.retrofit.datasource.NetworkDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
internal interface ApiModule {

    @Binds
    fun bindNetwrokDataSource(impl: RetrofitNetwork): NetworkDataSource


}