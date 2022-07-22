package com.example.trainingmobiled20

import android.app.SearchManager
import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.*
import android.widget.SearchView.OnQueryTextListener
import androidx.core.widget.ImageViewCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater= menuInflater
        inflater.inflate(R.menu.main_menu,menu)
        val manager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchItem= menu?.findItem(R.id.search1)
        val searchView= searchItem?.actionView as SearchView
        searchView.apply{
            setSearchableInfo(manager.getSearchableInfo(componentName))
            setIconifiedByDefault(false)
            setQueryHint("Enter stuff")
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