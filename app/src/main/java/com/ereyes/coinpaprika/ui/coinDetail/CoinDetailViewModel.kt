package com.ereyes.coinpaprika.ui.coinDetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ereyes.coinpaprika.common.Constants
import com.ereyes.coinpaprika.domain.GetCoinDetailUseCase
import com.ereyes.coinpaprika.domain.model.CoinDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/****
 * Project: CoinPaprika
 * From: com.ereyes.coinpaprika.ui.coinDetail
 * Created by Edgar Reyes Gonzalez on 4/12/2023 at 8:53 AM
 * All rights reserved 2023.
 ****/
@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    val getCoinDetailUseCase: GetCoinDetailUseCase
): ViewModel() {

    private val coinDetail: MutableLiveData<CoinDetail> = MutableLiveData<CoinDetail>()
    fun getResultCoinDetail(): MutableLiveData<CoinDetail> = coinDetail

    private val loaded: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    fun isLoaded(): MutableLiveData<Boolean> = loaded

    private val message: MutableLiveData<String> = MutableLiveData<String>()
    fun getMessage(): MutableLiveData<String> = message

    fun getCoinDetail(){
        viewModelScope.launch {
            try {
                loaded.value = Constants.SHOW
                val result = getCoinDetailUseCase()
                coinDetail.value = result
            }
            catch (e: Exception){
                message.value = e.message
            }
            finally {
                loaded.value = Constants.HIDE
            }
        }
    }
}