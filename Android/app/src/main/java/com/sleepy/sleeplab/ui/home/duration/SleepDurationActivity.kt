package com.sleepy.sleeplab.ui.home.duration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.sleepy.sleeplab.R
import com.sleepy.sleeplab.data.model.disorder.DisorderNewsObject
import com.sleepy.sleeplab.data.model.duration.DurationNewsObject
import com.sleepy.sleeplab.databinding.ActivitySleepDisorderBinding
import com.sleepy.sleeplab.databinding.ActivitySleepDurationBinding
import com.sleepy.sleeplab.ui.home.disorder.SleepDisorderAdapter

class SleepDurationActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySleepDurationBinding
    private lateinit var adapter: SleepDurationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySleepDurationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = SleepDurationAdapter(DurationNewsObject.dummyDuration)

        binding.rvDuration.adapter = adapter

        binding.rvDuration.layoutManager = LinearLayoutManager(this)
    }
}