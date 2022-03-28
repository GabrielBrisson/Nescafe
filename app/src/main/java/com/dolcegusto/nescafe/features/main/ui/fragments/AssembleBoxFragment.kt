package com.dolcegusto.nescafe.features.main.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dolcegusto.nescafe.R

class AssembleBoxFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_assemble_box, container, false)
    }

    companion object {
        fun newInstance() = AssembleBoxFragment()
    }

}