package com.example.saturnus_dimasbudi

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.saturnus_dimasbudi.pert4.FourthActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("onCreate", "MainActivity dibuat pertama kali")

        val btnToFourth = findViewById<Button>(R.id.btnToFourth)
        btnToFourth.setOnClickListener {
            val intent = Intent(this, FourthActivity::class.java).apply {
                putExtra("name", "Politeknik Caltex Riau")
                putExtra("from", "Rumbai")
                putExtra("age", 25)
            }
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("onStart", "onStart: MainActivity terlihat di layar")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy", "MainActivity dihapus dari stack")
    }
}
