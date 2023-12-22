package com.sleepy.sleeplab.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sleepy.sleeplab.R
import com.sleepy.sleeplab.ViewModelFactory
import com.sleepy.sleeplab.databinding.ActivityMainBinding
import com.sleepy.sleeplab.ui.chat.ChatActivity
import com.sleepy.sleeplab.ui.profile.ProfileActivity
import com.sleepy.sleeplab.ui.profile.UserDetailActivity
import com.sleepy.sleeplab.ui.quality.SleepQualityActivity
import com.sleepy.sleeplab.ui.welcome.WelcomeActivity

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel> {
        ViewModelFactory.getInstance(this)
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getSession().observe(this) {user ->
            if (!user.isLogin) {
                startActivity(Intent(this,WelcomeActivity::class.java))
                finish()
            }else{

            }
        }

        bottomNavigation()

    }

    private fun bottomNavigation() {
        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener { menuItems ->
            when(menuItems.itemId){
                R.id.navigation_home -> {
                    true
                }
                R.id.navigation_chat -> {
                    startActivity(Intent(this, ChatActivity::class.java))
                    true
                }
                R.id.navigation_profile -> {

                    startActivity(Intent(this, ProfileActivity::class.java))
                    true
                }

                else -> {
                    false
                }
            }
        }
    }

}