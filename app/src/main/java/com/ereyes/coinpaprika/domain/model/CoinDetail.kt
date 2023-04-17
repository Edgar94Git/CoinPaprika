package com.ereyes.coinpaprika.domain.model

import com.ereyes.coinpaprika.data.model.CoinDetailModel

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
    val Description: String,
    val Rank: Int,
    val IsActive: Boolean,
    val Logo: String
) {
    fun getNameComplete(): String {
        return "$Name ($Symbol)"
    }

    fun getIsActiveString(): String = if(IsActive) "active" else "inactive"
}

fun CoinDetailModel.toDomain() = CoinDetail(
    Id = id,
    Name = name,
    Symbol = symbol,
    Description = description,
    Rank = rank,
    IsActive = is_active,
    Logo = logo
)
