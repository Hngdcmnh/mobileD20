package com.example.trainingmobiled20

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.trainingmobiled20.databinding.FragmentStudentBinding

class StudentFragment : Fragment() {

    private lateinit var binding: FragmentStudentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStudentBinding.inflate(inflater,container,false)

        return binding.root
    }


}