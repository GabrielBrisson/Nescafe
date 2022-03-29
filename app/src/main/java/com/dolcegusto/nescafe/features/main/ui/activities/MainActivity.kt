package com.dolcegusto.nescafe.features.main.ui.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.dolcegusto.nescafe.R
import com.dolcegusto.nescafe.databinding.ActivityMainBinding
import com.dolcegusto.nescafe.features.main.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        transactFragment(viewModel.home)
        setupBottomMenu()

    }

    private fun setupBottomMenu() {
        binding.bottomNavMenu.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.itemHome -> transactFragment(viewModel.home)
                R.id.itemFlavors -> transactFragment(viewModel.flavors)
                R.id.itemMachines -> transactFragment(viewModel.machines)
                R.id.itemAssembleBox -> transactFragment(viewModel.assemble)
                R.id.itemProfile -> transactFragment(viewModel.profile)
            }
            true
        }
    }

    private fun transactFragment(fragment: Fragment) {
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.replace(R.id.containerMain, fragment)
        ft.commit()
    }

}