package com.ereyes.coinpaprika.data

import com.ereyes.coinpaprika.data.model.CoinModel
import com.ereyes.coinpaprika.data.model.coinDetail.CoinDetailModel
import com.ereyes.coinpaprika.data.network.CoinService
import com.ereyes.coinpaprika.domain.model.Coin
import com.ereyes.coinpaprika.domain.model.CoinDetail
import com.ereyes.coinpaprika.domain.model.toDomain
import javax.inject.Inject

/****
 * Project: CoinPaprika
 * From: com.ereyes.coinpaprika.data
 * Created by Edgar Reyes Gonzalez on 4/15/2023 at 9:08 PM
 * All rights reserved 2023.
 ****/
class CoinRepository @Inject constructor(
    private val api: CoinService
) {

    suspend fun getAllCoinsFromApi(): List<Coin>{
        val response: List<CoinModel> = api.getCoins()
        return response.map { it.toDomain() }
    }

    suspend fun getCoinDetail(id: String): CoinDetail {
        val response: CoinDetailModel = api.getCoinDetail(id)
        return response.toDomain()
    }
}