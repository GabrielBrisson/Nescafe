package com.dolcegusto.nescafe.features.home.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dolcegusto.nescafe.R
import com.dolcegusto.nescafe.databinding.FragmentHomeBinding
import com.dolcegusto.nescafe.features.home.ui.adapters.ViewPageAdapter

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

         val images = listOf(
             R.drawable.img_nescafe_home_background4,
            R.drawable.img_nescafe_home_background5,
            R.drawable.img_nescafe_home_background3,
            R.drawable.img_nescafe_home_background2,
            R.drawable.img_nescafe_home_background1
        )

        val adapter = ViewPageAdapter(images)
        binding.viewPager.adapter = adapter

        return binding.root
    }


}