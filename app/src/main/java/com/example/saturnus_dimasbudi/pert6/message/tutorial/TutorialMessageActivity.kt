package com.example.saturnus_dimasbudi.pert6.message.tutorial

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.saturnus_dimasbudi.R
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class TutorialMessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial_message)

        val viewPager = findViewById<ViewPager2>(R.id.tutorialMessageViewPager)
        val dotIndicator = findViewById<DotsIndicator>(R.id.dot_indicator)
        val btnFinishTutorial = findViewById<Button>(R.id.btnFinishTutorial)

        // Setup ViewPager2 dengan adapter
        val fragmentsList = listOf(Tutorial1Fragment(), Tutorial2Fragment(), Tutorial3Fragment())
        val adapter = TutorialFragmentAdapter(this, fragmentsList)
        viewPager.adapter = adapter

        // Hubungkan DotsIndicator dengan ViewPager2
        dotIndicator.attachTo(viewPager)

        btnFinishTutorial.setOnClickListener {
            finish()
        }
    }
}
