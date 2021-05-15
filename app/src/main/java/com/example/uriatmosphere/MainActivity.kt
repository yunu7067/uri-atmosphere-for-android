package com.example.uriatmosphere

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.uriatmosphere.openapi.ArpltnInforInqireSvc

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arpltnInforInqireSvc = ArpltnInforInqireSvc();
    }
}
