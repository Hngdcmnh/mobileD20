package com.example.training1_quanlyvexe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import com.example.training1_quanlyvexe.`object`.VeXe
import com.example.training1_quanlyvexe.adapter.CustomAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val arr: ArrayList<VeXe> = ArrayList()
        arr.add(VeXe("Nam Định - Hà Nội","29B-0536","5","19/07/2002"))
        arr.add(VeXe("Vĩnh Phúc - Hà Nội","19A-0123","8","25/07/2002"))
        arr.add(VeXe("Hà Nội - Vĩnh Phúc","20A-4567","16","10/08/2002"))
        val gdvDSVe : GridView = findViewById(R.id.gdvDSVe)
        gdvDSVe.adapter = CustomAdapter(this,arr)
    }
}