package com.dolcegusto.nescafe.features.main.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.dolcegusto.nescafe.features.home.ui.fragments.HomeFragment
import com.dolcegusto.nescafe.features.assemblebox.ui.fragments.AssembleBoxFragment
import com.dolcegusto.nescafe.features.main.ui.fragments.FlavorsFragment
import com.dolcegusto.nescafe.features.main.ui.fragments.MachinesFragment
import com.dolcegusto.nescafe.features.profile.ui.fragments.ProfileFragment
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel(){

    val home = HomeFragment.newInstance()
    val flavors = FlavorsFragment.newInstance()
    val machines = MachinesFragment.newInstance()
    val assemble = AssembleBoxFragment.newInstance()
    val profile = ProfileFragment.newInstance()
}