package com.sleepy.sleeplab.ui.home.disorder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sleepy.sleeplab.R
import com.sleepy.sleeplab.data.model.disorder.DisorderNewsObject
import com.sleepy.sleeplab.databinding.ActivitySleepDisorderBinding


class SleepDisorderActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivitySleepDisorderBinding
    private lateinit var adapter: SleepDisorderAdapter
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySleepDisorderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = SleepDisorderAdapter(DisorderNewsObject.dummyDisorder)

        binding.rvDisorder.adapter = adapter

        binding.rvDisorder.layoutManager = LinearLayoutManager(this)
    }

}