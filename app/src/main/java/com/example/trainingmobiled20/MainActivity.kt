package com.example.searchbar

import android.app.Activity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolBar_ve_da_xuat)
//        setSupportActionBar(toolbar)
//
//        toolbar?.inflateMenu(R.menu.menu_action_bar)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.veDaXuatFragment,
                R.id.quetVeFragment,
                R.id.khacFragment,
                R.id.xuatVeFragment
            )
        )
//
        val hostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        navController = hostFragment.navController

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bot_nav_view)

        //setupActionBarWithNavController(navController)
        bottomNavigationView.setupWithNavController(navController)
    }

}