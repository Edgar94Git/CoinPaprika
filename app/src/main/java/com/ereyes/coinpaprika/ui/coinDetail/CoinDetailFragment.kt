package com.ereyes.coinpaprika.ui.coinDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ereyes.coinpaprika.databinding.FragmentCoinDetailBinding
import com.ereyes.coinpaprika.domain.model.CoinDetail
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoinDetailFragment : Fragment() {

    private lateinit var binding: FragmentCoinDetailBinding
    private lateinit var idCoin: String
    private val viewModel by viewModels<CoinDetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        idCoin = arguments?.getString("id") ?: ""
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCoinDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservers()
        viewModel.getCoinDetail(idCoin)
    }

    private fun setUpObservers() {
        viewModel.getMessage().observe(viewLifecycleOwner){ msg ->
            Snackbar.make(binding.root, msg, Snackbar.LENGTH_LONG).show()
        }
        viewModel.isLoaded().observe(viewLifecycleOwner){ isLoaded ->

        }
        viewModel.getResultCoinDetail().observe(viewLifecycleOwner){ coinDetail ->
            loadedData(coinDetail)
        }
    }

    private fun loadedData(coinDetail: CoinDetail) {
        binding.tvName.text = coinDetail.getNameComplete()
        binding.tvRank.text = coinDetail.Rank.toString()
        binding.tvActive.text = coinDetail.getIsActiveString()
        binding.tvDescription.text = coinDetail.Description
    }
}