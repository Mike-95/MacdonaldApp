package com.example.macdonaldapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSummaryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            viewModel = sharedViewModel
            lifecycleOwner = viewLifecycleOwner

            //bidning variable to fragment instance
            summaryFragment = this@SummaryFragment

        }
    }

    fun sendOrder() {
        Toast.makeText(activity, "Send Order", Toast.LENGTH_SHORT).show()
    }

}
