package com.example.macdonaldapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.macdonaldapp.R
import com.example.macdonaldapp.databinding.FragmentFlavorBinding
import com.example.macdonaldapp.model.OrderViewModel


class FlavorFragment : Fragment() {

    private lateinit var binding: FragmentFlavorBinding

    // Getting reference of shared view model;
    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFlavorBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            viewModel = sharedViewModel
        }

        binding.btnFlavorNext.setOnClickListener {
            findNavController().navigate(R.id.action_flavorFragment_to_pickupFragment)
        }
    }
}
