package com.ereyes.coinpaprika.data.model

import com.google.gson.annotations.SerializedName

/****
 * Project: CoinPaprika
 * From: com.ereyes.coinpaprika.data.model
 * Created by Edgar Reyes Gonzalez on 4/12/2023 at 8:57 AM
 * All rights reserved 2023.
 ****/
data class CoinModel(
    @SerializedName("id") val Id: String,
    @SerializedName("name") val Name: String,
    @SerializedName("symbol") val Symbol: String,
    @SerializedName("rank") val Rank: Int,
    @SerializedName("is_new") val IsNew: Boolean,
    @SerializedName("is_active") val IsActive: Boolean,
    @SerializedName("type") val Type: String
)