package com.example.saturnus_dimasbudi.pert6

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.saturnus_dimasbudi.R

class SixthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_six)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val btnFragment1 = findViewById<Button>(R.id.btnFragment1)
        val btnFragment2 = findViewById<Button>(R.id.btnFragment2)
        val btnFragment3 = findViewById<Button>(R.id.btnFragment3)

        // Setup Toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            title = "Pertemuan 6 - Fragment"
            setDisplayHomeAsUpEnabled(true)
        }
        toolbar.setNavigationOnClickListener { finish() }

        // Menampilkan fragment pertama secara default jika belum ada state tersimpan
        if (savedInstanceState == null) {
            replaceFragment(SatuFragment())
        }

        // Event click untuk mengganti fragment
        btnFragment1.setOnClickListener {
            replaceFragment(SatuFragment())
        }

        btnFragment2.setOnClickListener {
            replaceFragment(DuaFragment())
        }

        btnFragment3.setOnClickListener {
            replaceFragment(TigaFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}
