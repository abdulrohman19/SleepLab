package com.sleepy.sleeplab.ui.quality

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.sleepy.sleeplab.R
import com.sleepy.sleeplab.databinding.ActivitySleepQualityBinding

class SleepQualityActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySleepQualityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySleepQualityBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }


}