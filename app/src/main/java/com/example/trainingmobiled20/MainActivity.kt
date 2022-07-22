package com.example.trainingmobiled20

import android.app.SearchManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.SearchView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)

        // Associate searchable configuration with the SearchView
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView : SearchView? = menu?.let {
            menu.findItem(R.id.search_button).actionView as SearchView
        }
        searchView?.setSearchableInfo(searchManager.getSearchableInfo(componentName))

        searchView?.apply {
            background = AppCompatResources.getDrawable(applicationContext, R.drawable.shape_bg_search)
            queryHint = getString(R.string.search_hint)
        }

        return true
    }
}
