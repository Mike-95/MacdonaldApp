package com.example.macdonaldapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.macdonaldapp.R
import com.example.macdonaldapp.databinding.FragmentHomeBinding
import com.example.macdonaldapp.model.OrderViewModel


class HomeFragment : Fragment() {

    private var quantity = 0
    private lateinit var binding: FragmentHomeBinding

    // Getting reference of shared view model;
    private val sharedViewModel: OrderViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //binding new data variable to the fragment instance
        binding.startFragment = this

        binding.tvDipslay.text = quantity.toString()

        binding.ivAdd.setOnClickListener { increment() }
        binding.ivCut.setOnClickListener {decrement()}
        binding.btnSubmit.setOnClickListener { orderQuantity(quantity) }

    }

    private fun increment() {
        binding.tvDipslay.text = (++quantity).toString()
    }

    private fun decrement() {
        if (quantity == 0) {
            binding.tvDipslay.text = quantity.toString()
        } else {
            binding.tvDipslay.text = (--quantity).toString()
        }
    }

     fun orderQuantity(quantity: Int){
        sharedViewModel.setQuantity(quantity)
        if (sharedViewModel.hasNoFlavorSet()){
            sharedViewModel.setFlavor(getString(R.string.big_mac))
        }
         if (quantity == 0){
             Toast.makeText(context, "Choose order amount", Toast.LENGTH_SHORT).show()
         }else{
             findNavController().navigate(R.id.action_homeFragment_to_flavorFragment)
         }


    }
}
