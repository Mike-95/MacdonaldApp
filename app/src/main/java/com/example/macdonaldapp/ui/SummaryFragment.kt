package com.example.macdonaldapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.macdonaldapp.R
import com.example.macdonaldapp.databinding.FragmentSummaryBinding
import com.example.macdonaldapp.model.OrderViewModel


class SummaryFragment : Fragment() {

    // Initialize binding view
    private lateinit var binding: FragmentSummaryBinding


    // Getting reference of shared view model;
    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSummaryBinding.inflate(inflater, container, false)
        return binding.root
    }

}
