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

//        setupView()
        setupAction()
    }

//    private fun setupView() {
//        @Suppress("DEPRECATION")
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
//            window.insetsController?.hide(WindowInsets.Type.statusBars())
//        } else {
//            window.setFlags(
//                WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN
//            )
//        }
//        supportActionBar?.show()
//    }

    private fun setupAction() {
        binding.loginButton.setOnClickListener{
            startActivity(Intent(this,LoginActivity::class.java))
        }
        binding.signupButton.setOnClickListener{
            startActivity(Intent(this,RegisterActivity::class.java))
        }
    }
}