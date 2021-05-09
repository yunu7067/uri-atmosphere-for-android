package com.example.uriatmosphere

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uriatmosphere.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onNavigationItemSelected()
        setContentView(R.layout.activity_main)
    }


    fun onNavigationItemSelected(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        val bottom_navigation = binding.bottomNavigation

        bottom_navigation.setOnNavigationItemReselectedListener { item ->
            when(item.itemId) {
                R.id.bottom_navigation_menu_home -> {

                }
                R.id.bottom_navigation_menu_search -> {

                }
                R.id.bottom_navigation_menu_setting -> {

                }
            }
        }
    }
}