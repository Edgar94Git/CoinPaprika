package com.ereyes.coinpaprika.ui.coins

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.ereyes.coinpaprika.R
import com.ereyes.coinpaprika.databinding.FragmentCoinsBinding
import com.ereyes.coinpaprika.ui.coins.adapater.CoinAdapter
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CoinsFragment : Fragment() {

    private val viewModel by viewModels<CoinsViewModel>()
    private lateinit var binding: FragmentCoinsBinding
    private lateinit var adapter: CoinAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpObservers()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCoinsBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun setUpObservers() {
        viewModel.getResult().observe(viewLifecycleOwner){ coins->
            if(coins.isNotEmpty())
            {

            }
        }
        viewModel.getMessages().observe(viewLifecycleOwner){ msg ->
            Snackbar.make(binding.root, msg, Snackbar.LENGTH_SHORT).show()
        }
    }
}