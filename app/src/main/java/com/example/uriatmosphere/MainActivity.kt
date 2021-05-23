package com.example.uriatmosphere

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.uriatmosphere.component.stationview.StationViewAdapter
import com.example.uriatmosphere.data.AppDatabase
import com.example.uriatmosphere.databinding.ActivityMainBinding
import com.example.uriatmosphere.openapi.ArpltnInforInqireSvc
import com.example.uriatmosphere.openapi.model.MsrstnAcctoRltmMesureDnstyData
import com.google.android.material.navigation.NavigationView
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityMainBinding
    private var data: MsrstnAcctoRltmMesureDnstyData? = null
    private lateinit var db: RoomDatabase

    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Load Room Database
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).build()

        // Toolbar 레이아웃 구성
        val appbar: Toolbar = binding.toolbar
        val navigationView: NavigationView = binding.navigationView
        setSupportActionBar(appbar)
        navigationView.setNavigationItemSelectedListener(this)

        // Station Card 레이아웃 구성
        viewManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        viewAdapter = StationViewAdapter()
        recyclerView = binding.stationsView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            // 툴바의 네비게이션 버튼이 눌렸을 때
            android.R.id.home -> {
                binding.drawerLayout.openDrawer(GravityCompat.START)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private var countClickBackButton: Int = 0
    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawers()
        } else {
            if (countClickBackButton <= 0) {
                Toast.makeText(this, "종료하려면 한번 더 눌러주세요.", Toast.LENGTH_SHORT).show()

                countClickBackButton++
            } else {
                super.onBackPressed()
            }
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.search_menu -> {
                Toast.makeText(this, "search_menu clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.favorites_menu -> {
                Toast.makeText(this, "favorites_menu clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.settings_menu -> {
                Toast.makeText(this, "settings_menu clicked", Toast.LENGTH_SHORT).show()
            }
        }
        return false
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
