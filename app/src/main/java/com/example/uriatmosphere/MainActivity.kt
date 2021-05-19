package com.example.uriatmosphere

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uriatmosphere.component.stationview.StationViewAdapter
import com.example.uriatmosphere.databinding.ActivityMainBinding
import com.example.uriatmosphere.openapi.ArpltnInforInqireSvc
import com.example.uriatmosphere.openapi.model.MsrstnAcctoRltmMesureDnstyData
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var data: MsrstnAcctoRltmMesureDnstyData? = null

    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Station Card 레이아웃 구성
        viewManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        viewAdapter = StationViewAdapter()
        recyclerView = binding.stationsView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

    }

    private fun updateData() {
        thread {
            val arpltnInforInqireSvc = ArpltnInforInqireSvc()
            data = arpltnInforInqireSvc.MsrstnAcctoRltmMesureDnsty().get()
            Log.e("MainActivity", "clicked!")
            runOnUiThread {
                // 여기서 UI 상태 변경
                data?.getItems()?.toString() ?: "null value!"
            }
        }
    }
}
