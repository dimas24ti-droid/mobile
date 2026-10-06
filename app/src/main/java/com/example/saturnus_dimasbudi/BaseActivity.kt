package com.example.saturnus_dimasbudi

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.saturnus_dimasbudi.pert6.home.HomeFragment
import com.example.saturnus_dimasbudi.pert6.message.MessageFragment
import com.example.saturnus_dimasbudi.pert6.more.MoreFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        val mainLayout = findViewById<View>(R.id.main)
        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottom_nav_view)

        // Mencegah jarak kosong berlebih di bagian bawah akibat inset navigasi sistem
        ViewCompat.setOnApplyWindowInsetsListener(mainLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        // Tampilkan HomeFragment sebagai default
        if (savedInstanceState == null) {
            replaceFragment(HomeFragment())
        }

        bottomNavView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.message -> {
                    replaceFragment(MessageFragment())
                    true
                }
                R.id.more -> {
                    replaceFragment(MoreFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
