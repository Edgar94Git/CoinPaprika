package com.ereyes.coinpaprika.domain

import com.ereyes.coinpaprika.data.CoinRepository
import com.ereyes.coinpaprika.domain.model.CoinDetail
import javax.inject.Inject

/****
 * Project: CoinPaprika
 * From: com.ereyes.coinpaprika.domain
 * Created by Edgar Reyes Gonzalez on 4/16/2023 at 2:26 PM
 * All rights reserved 2023.
 ****/
class GetCoinDetailUseCase @Inject constructor(private val repository: CoinRepository) {
    suspend operator fun invoke(): CoinDetail {
        return repository.getCoinDetail("btc-bitcoin")
    }
}