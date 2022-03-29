package com.dolcegusto.nescafe.features.main.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.dolcegusto.nescafe.R
import com.dolcegusto.nescafe.databinding.ActivityMainBinding
import com.dolcegusto.nescafe.features.home.ui.fragments.HomeFragment
import com.dolcegusto.nescafe.features.main.ui.fragments.AssembleBoxFragment
import com.dolcegusto.nescafe.features.main.ui.fragments.FlavorsFragment
import com.dolcegusto.nescafe.features.main.ui.fragments.MachinesFragment
import com.dolcegusto.nescafe.features.profile.ui.fragments.ProfileFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomMenu()

    }

    private fun setupBottomMenu() {
        val home = HomeFragment.newInstance()
        val flavors = FlavorsFragment.newInstance()
        val machines = MachinesFragment.newInstance()
        val assemble = AssembleBoxFragment.newInstance()
        val profile = ProfileFragment.newInstance()

        transactFragment(home)
        binding.bottomNavMenu.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.itemHome -> transactFragment(home)
                R.id.itemFlavors -> transactFragment(flavors)
                R.id.itemMachines -> transactFragment(machines)
                R.id.itemAssembleBox -> transactFragment(assemble)
                R.id.itemProfile -> transactFragment(profile)
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