package com.example.uriatmosphere

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.uriatmosphere.databinding.ActivityMainBinding
import com.example.uriatmosphere.pages.home.HomeFragment
import com.example.uriatmosphere.pages.search.SearchFragment
import com.example.uriatmosphere.pages.setting.SettingFragment

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    val pages = listOf(HomeFragment(), SearchFragment(), SettingFragment())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // 2. onCreateView 함수가 호출된 후 뷰 객체를 초기화함
        viewPager = findViewById(R.id.view_pager)

        // 3. viewPager 뷰 객체에 어댑터 적용하기
        viewPager.adapter = ViewPagerAdapter(this)
    }


    inner class ViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int {
            return 3
        }

        override fun createFragment(position: Int): Fragment {
            return pages.get(position)
        }
    }
}
