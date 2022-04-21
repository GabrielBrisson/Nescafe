package com.dolcegusto.nescafe.features.assemblebox.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.dolcegusto.nescafe.R
import com.dolcegusto.nescafe.databinding.FragmentAssembleBoxBinding
import com.dolcegusto.nescafe.features.assemblebox.ui.viewmodels.AssembleBoxViewModel

class AssembleBoxFragment : Fragment() {

    private lateinit var binding: FragmentAssembleBoxBinding
    private val viewModel : AssembleBoxViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAssembleBoxBinding.inflate(layoutInflater, container, false)


        return binding.root
    }

    companion object {
        fun newInstance() = AssembleBoxFragment()
    }

}