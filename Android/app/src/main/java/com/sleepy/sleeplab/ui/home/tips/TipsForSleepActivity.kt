package com.sleepy.sleeplab.ui.home.tips

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.sleepy.sleeplab.data.model.tips.TipsNewsObject
import com.sleepy.sleeplab.databinding.ActivityDurationWebViewBinding
import com.sleepy.sleeplab.databinding.ActivityTipsForSleepBinding
import com.sleepy.sleeplab.ui.home.duration.SleepDurationAdapter

class TipsForSleepActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTipsForSleepBinding
    private lateinit var adapter: TipsForSleepAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTipsForSleepBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = TipsForSleepAdapter(TipsNewsObject.dummyTips)

        binding.rvTips.adapter = adapter

        binding.rvTips.layoutManager = LinearLayoutManager(this)
    }
}