package com.ereyes.coinpaprika.ui.coins.adapater

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ereyes.coinpaprika.databinding.ItemCoinBinding
import com.ereyes.coinpaprika.domain.model.Coin

/****
 * Project: CoinPaprika
 * From: com.ereyes.coinpaprika.ui.coins.adapater
 * Created by Edgar Reyes Gonzalez on 4/15/2023 at 9:22 PM
 * All rights reserved 2023.
 ****/
class CoinViewHolder(view: View): ViewHolder(view) {
    private val binding = ItemCoinBinding.bind(view)
    fun sender(coin: Coin){
        binding.tvName.text = coin.getNameComplete()
        binding.tvActive.text = coin.getIsActiveString()
    }
}