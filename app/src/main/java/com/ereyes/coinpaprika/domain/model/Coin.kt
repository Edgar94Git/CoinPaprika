package com.ereyes.coinpaprika.domain.model

import com.ereyes.coinpaprika.data.model.CoinModel

/****
 * Project: CoinPaprika
 * From: com.ereyes.coinpaprika.domain.model
 * Created by Edgar Reyes Gonzalez on 4/15/2023 at 9:10 PM
 * All rights reserved 2023.
 ****/
data class Coin(
    val Id: String,
    val Name: String,
    val Symbol: String,
    val Rank: Int,
    val IsNew: Boolean,
    val IsActive: Boolean,
    val Type: String
) {
    fun getNameComplete(): String {
        return "$Name ($Symbol)"
    }

    fun getIsActiveString(): String = if(IsActive) "Activo" else "Desactivo"
}

fun CoinModel.toDomain() = Coin(
    Id = Id,
    Name = Name,
    Symbol = Symbol,
    Rank = Rank,
    IsNew = IsNew,
    IsActive = IsActive,
    Type = Type
)