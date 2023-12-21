package com.sleepy.sleeplab.ui.quality.result

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sleepy.sleeplab.R
import com.sleepy.sleeplab.databinding.ActivityQualityResultBinding

class QualityResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQualityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQualityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)




    }
}