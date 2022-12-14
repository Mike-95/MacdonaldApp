package com.example.macdonaldapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
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

            //binding variable to fragment instance
            summaryFragment = this@SummaryFragment

        }
    }

    fun sendOrder() {
        val orderSummary = getString(
            R.string.order_details,
            sharedViewModel.quantity.value.toString(),
            sharedViewModel.flavor.value.toString(),
            sharedViewModel.data.value.toString(),
            sharedViewModel.price.value.toString()
        )

        val intent = Intent(Intent.ACTION_SEND)
            .setType("text/plain")
            .putExtra(Intent.EXTRA_SUBJECT, getString(R.string.new_cupcake_order))
            .putExtra(Intent.EXTRA_TEXT, orderSummary)

        // Check if there is an app to handle it
        if (activity?.packageManager?.resolveActivity(intent, 0) != null){
            startActivity(intent)
        }
    }

    // Implementing cancel button to back fragment to home fragment
    fun cancelOrder() {
        sharedViewModel.resetOrder()
        findNavController().navigate(R.id.action_summaryFragment_to_homeFragment)
    }

}
