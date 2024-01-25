package com.alhussain.retrofit.di

import com.alhussain.retrofit.RetrofitAxiomNetwork
import com.alhussain.retrofit.datasource.AxiomNetworkDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface ApiModule {

    @Binds
    fun bindAxiomNetwrokDataSource(impl: RetrofitAxiomNetwork): AxiomNetworkDataSource
}