package com.sleepy.sleeplab.ui.welcome

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import com.sleepy.sleeplab.R
import com.sleepy.sleeplab.databinding.ActivityWelcomeBinding
import com.sleepy.sleeplab.ui.login.LoginActivity
import com.sleepy.sleeplab.ui.register.RegisterActivity

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAction()
    }


    private fun setupAction() {
        binding.loginButton.setOnClickListener{
            startActivity(Intent(this,LoginActivity::class.java))
        }
        binding.signupButton.setOnClickListener{
            startActivity(Intent(this,RegisterActivity::class.java))
        }
    }
}