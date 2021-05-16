package com.example.uriatmosphere

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.uriatmosphere.databinding.ActivityMainBinding
import com.example.uriatmosphere.openapi.ArpltnInforInqireSvc
import com.example.uriatmosphere.openapi.model.MsrstnAcctoRltmMesureDnstyData
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var data: MsrstnAcctoRltmMesureDnstyData? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.testButton.setOnClickListener {
            showData(it)
        }
    }

    private fun showData(view: View) {
        thread {
            val arpltnInforInqireSvc = ArpltnInforInqireSvc()
            data = arpltnInforInqireSvc.MsrstnAcctoRltmMesureDnsty().get()
            Log.e("MainActivity", "clicked!")
            runOnUiThread {
                binding.testTextview.text = data?.getItems()?.toString() ?: "null value!"
            }
        }
    }
}
