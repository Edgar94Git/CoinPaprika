package com.ereyes.coinpaprika.di

import com.ereyes.coinpaprika.common.Constants
import com.ereyes.coinpaprika.data.network.CoinApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/****
 * Project: CoinPaprika
 * From: com.ereyes.coinpaprika.di
 * Created by Edgar Reyes Gonzalez on 4/12/2023 at 9:21 AM
 * All rights reserved 2023.
 ****/
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideCoinApiClient(retrofit: Retrofit): CoinApiClient {
        return retrofit.create(CoinApiClient::class.java)
    }
}