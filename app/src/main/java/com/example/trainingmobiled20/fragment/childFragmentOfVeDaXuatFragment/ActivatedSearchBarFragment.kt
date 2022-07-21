package com.example.searchbar.fragment.childFragmentOfVeDaXuatFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.searchbar.R

class ActivatedSearchBarFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myView = inflater.inflate(R.layout.fragment_activated_search_bar, container, false)
        val searchButton = myView.findViewById<ImageView>(R.id.search_button)
        searchButton.setOnClickListener{
            parentFragment?.childFragmentManager?.beginTransaction()
                ?.replace(R.id.frl_search_bar_container, UnActivatedSearchBarFragment())
                ?.addToBackStack(null)
                ?.commit();
        }

        return myView
    }
}