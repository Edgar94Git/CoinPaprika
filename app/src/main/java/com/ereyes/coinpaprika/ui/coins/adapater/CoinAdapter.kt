package com.ereyes.coinpaprika.ui.coins.adapater

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ereyes.coinpaprika.R
import com.ereyes.coinpaprika.domain.model.Coin

/****
 * Project: CoinPaprika
 * From: com.ereyes.coinpaprika.ui.coins.adapater
 * Created by Edgar Reyes Gonzalez on 4/15/2023 at 8:58 PM
 * All rights reserved 2023.
 ****/

class CoinAdapter(private var coins: List<Coin>, private val onCoinSelected: (Coin) -> Unit)
    : RecyclerView.Adapter<CoinViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_coin, parent, false)
        return CoinViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val coin = coins[position]
        holder.sender(coin)
        holder.itemView.setOnClickListener {
            onCoinSelected(coin)
        }
    }

    override fun getItemCount() = coins.size

    fun updateListCoin(coins: List<Coin>){
        this.coins = coins
        notifyDataSetChanged()
    }
}