package com.sleepy.sleeplab.ui.etc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import com.sleepy.sleeplab.R
import com.sleepy.sleeplab.ui.main.MainActivity
import com.sleepy.sleeplab.ui.welcome.WelcomeActivity

class SpashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAGS_CHANGED
        )
        supportActionBar?.hide()
        Handler(Looper.getMainLooper()).postDelayed({
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        },3000 )
    }
}