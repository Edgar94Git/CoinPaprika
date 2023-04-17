package com.ereyes.coinpaprika.data.network

import com.ereyes.coinpaprika.data.model.CoinModel
import com.ereyes.coinpaprika.data.model.CoinDetailModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/****
 * Project: CoinPaprika
 * From: com.ereyes.coinpaprika.data.network
 * Created by Edgar Reyes Gonzalez on 4/15/2023 at 9:03 PM
 * All rights reserved 2023.
 ****/
class CoinService @Inject constructor(private val api: CoinApiClient) {

    suspend fun getCoins(): List<CoinModel> = withContext(Dispatchers.IO){
        api.getCoins()
    }

    suspend fun getCoinDetail(id: String): CoinDetailModel = withContext(Dispatchers.IO){
        api.getCoinDetail(id)
    }
}