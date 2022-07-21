package com.example.searchbar.fragment.childFragmentOfVeDaXuatFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.searchbar.MainActivity
import com.example.searchbar.R
import com.example.searchbar.Util

class UnActivatedSearchBarFragment : Fragment() {

    private lateinit var edtSearchBar: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun setOnClick() {
    }

    private fun setViewById(view: View?) {
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myView = inflater.inflate(R.layout.fragment_un_activated_search_bar, container, false)

        edtSearchBar = myView.findViewById(R.id.edt_search_bar)

        val cancelSearchButton = myView.findViewById<TextView>(R.id.cancel_search_button)
        cancelSearchButton.setOnClickListener {
            parentFragment?.childFragmentManager?.popBackStack()
            activity?.let { Util.showSoftKeyboard(it) }
        }

        return myView
    }

    override fun onResume() {
        edtSearchBar.requestFocus()
        activity?.let { Util.showSoftKeyboard(it) }
        super.onResume()
    }
}