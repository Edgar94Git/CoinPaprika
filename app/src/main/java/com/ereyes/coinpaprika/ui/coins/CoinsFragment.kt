package com.ereyes.coinpaprika.ui.coins

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ereyes.coinpaprika.R
import com.ereyes.coinpaprika.common.Constants
import com.ereyes.coinpaprika.databinding.FragmentCoinsBinding
import com.ereyes.coinpaprika.domain.model.Coin
import com.ereyes.coinpaprika.ui.coinDetail.CoinDetailFragment
import com.ereyes.coinpaprika.ui.coins.adapater.CoinAdapter
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CoinsFragment : Fragment() {

    private val viewModel by viewModels<CoinsViewModel>()
    private lateinit var binding: FragmentCoinsBinding
    private lateinit var coinAdapter: CoinAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getAllCoins()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCoinsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservers()
        setUpAdapters()
    }

    private fun setUpAdapters() {
        coinAdapter = CoinAdapter(emptyList()){ position -> onCoinSelected(position)}
        binding.rvCoins.adapter = coinAdapter
        binding.rvCoins.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun setUpObservers() {
        viewModel.getResult().observe(viewLifecycleOwner){ coins->
            coinAdapter.updateListCoin(coins)
        }
        viewModel.getMessages().observe(viewLifecycleOwner){ msg ->
            Snackbar.make(binding.root, msg, Snackbar.LENGTH_SHORT).show()
        }
        viewModel.isLoaded().observe(viewLifecycleOwner){ isLoaded ->
            binding.pbLoadedCoins.isVisible = isLoaded
        }
    }

    private fun onCoinSelected(coin: Coin){

        val arguments = Bundle()
        arguments.putString(Constants.ID, coin.Id)

        val fragment = CoinDetailFragment()
        fragment.arguments = arguments

        parentFragmentManager.beginTransaction()
            .replace(R.id.host_container_main, fragment)
            .addToBackStack(null)
            .commit()
    }

}