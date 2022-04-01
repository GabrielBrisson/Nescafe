package com.dolcegusto.nescafe.features.profile.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dolcegusto.nescafe.databinding.ActivityAccountInfoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AccountInfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAccountInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccountInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            toolbar.setNavigationOnClickListener {
                onBackPressed()
            }
        }
    }
}