package com.example.trainingmobiled20

import android.app.SearchManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import android.widget.SearchView.OnQueryTextListener
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater= menuInflater
        inflater.inflate(R.menu.menu_item,menu)
        val manager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchItem= menu?.findItem(R.id.search_action)
        val searchView= searchItem?.actionView as SearchView

        searchView.apply{
            setSearchableInfo(manager.getSearchableInfo(componentName))
            setIconifiedByDefault(false)
            setOnQueryTextListener(object: OnQueryTextListener
            {
                override fun onQueryTextSubmit(query: String?):Boolean{
                    searchView.clearFocus()
                    searchView.setQuery("",false)
                    searchItem.collapseActionView()
                    Toast.makeText(this@MainActivity,"$query",Toast.LENGTH_LONG).show()
                    return true
                }
                override fun onQueryTextChange(p0: String?): Boolean {
                    return false
                }
            })
        }




        return true
    }
}