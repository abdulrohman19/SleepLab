package com.sleepy.sleeplab.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sleepy.sleeplab.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigation.setOnNavigationItemSelectedListener { menuItems ->
            when(menuItems.itemId){
                R.id.navigation_home -> {
                    true
                }
                R.id.navigation_sleep -> {
                    //intent
                    true
                }
                R.id.navigation_profile -> {
                    true
                }

                else -> {
                    false
                }
            }
        }


    }
}