package com.ereyes.coinpaprika.data.network

import com.ereyes.coinpaprika.data.model.CoinModel
import com.ereyes.coinpaprika.data.model.coinDetail.CoinDetailModel
import com.ereyes.coinpaprika.domain.model.CoinDetail
import retrofit2.http.GET
import retrofit2.http.Path

/****
 * Project: CoinPaprika
 * From: com.ereyes.coinpaprika.data.network
 * Created by Edgar Reyes Gonzalez on 4/12/2023 at 9:10 AM
 * All rights reserved 2023.
 ****/
interface CoinApiClient {
    @GET("v1/coins")
    suspend fun getCoins(): List<CoinModel>

    @GET("v1/coins/{id}")
    suspend fun getCoinDetail(
        @Path("id") id: String
    ): CoinDetailModel
}