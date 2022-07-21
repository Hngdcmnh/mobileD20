package com.example.searchbar.fragment

import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.searchbar.R
import com.example.searchbar.fragment.childFragmentOfVeDaXuatFragment.ActivatedSearchBarFragment

class VeDaXuatFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val menuHost: MenuHost = requireActivity()
//
//        menuHost.addMenuProvider(object : MenuProvider {
//            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
//                menuInflater.inflate(R.menu.menu_action_bar, menu)
//            }
//
//            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
//                return when (menuItem.itemId) {
//                    R.id.search_button -> {
//                        true
//                    }
//
//                    R.id.filter_button -> {
//                        Toast.makeText(context, "Đã nhấn vào filter", Toast.LENGTH_SHORT)
//                        true
//                    }
//                    else -> {
//                        false
//                    }
//                }
//            }
//
//        })

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val myView = inflater.inflate(R.layout.fragment_ve_da_xuat, container, false)
        val filterButton = myView.findViewById<ImageView>(R.id.filter_button)
        filterButton?.setOnClickListener {
            Toast.makeText(context, "Đã nhấn vào filter!", Toast.LENGTH_SHORT).show()
        }

        val fragmentTransaction: FragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.frl_search_bar_container, ActivatedSearchBarFragment())
        fragmentTransaction.commit()

        // Inflate the layout for this fragment
        return myView
    }
}