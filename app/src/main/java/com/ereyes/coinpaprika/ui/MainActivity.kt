package com.ereyes.coinpaprika.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ereyes.coinpaprika.R
import com.ereyes.coinpaprika.databinding.ActivityMainBinding
import com.ereyes.coinpaprika.ui.coins.CoinsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.host_container_main, CoinsFragment())
            .commit()
    }
}