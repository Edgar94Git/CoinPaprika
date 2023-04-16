package com.ereyes.coinpaprika.domain

import com.ereyes.coinpaprika.data.CoinRepository
import com.ereyes.coinpaprika.domain.model.Coin
import javax.inject.Inject

/****
 * Project: CoinPaprika
 * From: com.ereyes.coinpaprika.domain
 * Created by Edgar Reyes Gonzalez on 4/15/2023 at 9:16 PM
 * All rights reserved 2023.
 ****/
class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository) {

    suspend operator fun invoke(): List<Coin>{
        return repository.getAllCoinsFromApi()
    }

}