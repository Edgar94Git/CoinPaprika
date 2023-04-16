package com.ereyes.coinpaprika.ui.coins

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ereyes.coinpaprika.common.Constants
import com.ereyes.coinpaprika.domain.GetCoinsUseCase
import com.ereyes.coinpaprika.domain.model.Coin
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/****
 * Project: CoinPaprika
 * From: com.ereyes.coinpaprika.ui.coins
 * Created by Edgar Reyes Gonzalez on 4/12/2023 at 8:50 AM
 * All rights reserved 2023.
 ****/
@HiltViewModel
class CoinsViewModel @Inject constructor(
    val getCoinsUseCase: GetCoinsUseCase
): ViewModel() {

    private val messages: MutableLiveData<String> = MutableLiveData<String>()
    fun getMessages(): MutableLiveData<String> = messages

    private val loaded: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    fun isLoaded(): MutableLiveData<Boolean> = loaded

    private val result: MutableLiveData<List<Coin>> = MutableLiveData<List<Coin>>()
    fun getResult(): MutableLiveData<List<Coin>> = result
    fun getAllCoins(){
        viewModelScope.launch {
            try {
                loaded.value = Constants.SHOW
                val resultServer = getCoinsUseCase()
                if(resultServer != null)
                    result.value = resultServer!!
            }
            catch (e: Exception){
                messages.value = e.message
            }
            finally {
                loaded.value = Constants.HIDE
            }
        }
    }
}