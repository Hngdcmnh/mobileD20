package com.example.trainingmobiled20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val search: ImageView = findViewById(R.id.imageView4)
        val editTextSearch: EditText = findViewById(R.id.editTextSearch)
        editTextSearch.isVisible = false
        search.setOnClickListener(View.OnClickListener {
            editTextSearch.isVisible = true
        })
    }
}