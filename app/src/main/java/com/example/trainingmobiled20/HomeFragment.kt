package com.example.trainingmobiled20

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.trainingmobiled20.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.btToDemo1.setOnClickListener {
            goToDemoRecyclerFrag()
        }
    }

    private fun goToDemoRecyclerFrag() {
        parentFragmentManager.commit {
            replace<DemoRecyclerFragment>(R.id.fragment_container_view)
            setReorderingAllowed(true)
            addToBackStack(null)
        }
    }
}