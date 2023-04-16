package com.ereyes.coinpaprika.domain.model

import com.ereyes.coinpaprika.data.model.coinDetail.CoinDetailModel
import java.util.jar.Attributes.Name

/****
 * Project: CoinPaprika
 * From: com.ereyes.coinpaprika.domain.model
 * Created by Edgar Reyes Gonzalez on 4/16/2023 at 2:22 PM
 * All rights reserved 2023.
 ****/
data class CoinDetail(
    val Id: String,
    val Name: String,
    val Symbol: String,
    val Description: String
)

fun CoinDetailModel.toDomain() = CoinDetail(Id = id, Name = name, Symbol = symbol, Description = description )
