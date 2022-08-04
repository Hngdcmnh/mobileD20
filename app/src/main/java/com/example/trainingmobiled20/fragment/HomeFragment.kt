package com.example.trainingmobiled20.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.trainingmobiled20.R
import com.example.trainingmobiled20.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        setOnClick()

        return binding.root
    }

    private fun setOnClick() {
        binding.btnDemo.setOnClickListener {
            goToDemoFragment()
        }

        binding.btnGoFood.setOnClickListener {
            goToGoFoodFragment()
        }
    }

    private fun goToDemoFragment() {
        findNavController().navigate(R.id.action_homeFragment_to_demoFragment)
    }

    private fun goToGoFoodFragment() {
        findNavController().navigate(R.id.action_homeFragment_to_goFoodFragment)

    }
}