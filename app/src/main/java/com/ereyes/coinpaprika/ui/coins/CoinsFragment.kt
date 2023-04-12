package com.ereyes.coinpaprika.ui.coins

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ereyes.coinpaprika.R
import com.ereyes.coinpaprika.databinding.FragmentCoinsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoinsFragment : Fragment() {

    private lateinit var binding: FragmentCoinsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCoinsBinding.inflate(inflater, container, false)
        return binding.root
    }
}