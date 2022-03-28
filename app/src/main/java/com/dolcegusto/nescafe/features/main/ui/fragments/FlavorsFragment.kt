package com.dolcegusto.nescafe.features.main.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dolcegusto.nescafe.databinding.FragmentFlavorsBinding

class FlavorsFragment : Fragment() {

    private lateinit var binding: FragmentFlavorsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlavorsBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        fun newInstance() = FlavorsFragment()
    }
}