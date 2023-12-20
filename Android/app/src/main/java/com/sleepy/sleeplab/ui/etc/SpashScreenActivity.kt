package com.sleepy.sleeplab.ui.etc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.sleepy.sleeplab.R
import com.sleepy.sleeplab.ui.main.MainActivity
import com.sleepy.sleeplab.ui.welcome.WelcomeActivity

class SpashScreenActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 5000 // Timeout dalam milidetik (3 detik)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spash_screen)

        Handler().postDelayed({
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_TIME_OUT)
    }
}