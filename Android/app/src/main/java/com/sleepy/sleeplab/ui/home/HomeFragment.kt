package com.sleepy.sleeplab.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.sleepy.sleeplab.R
import com.sleepy.sleeplab.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnDuration.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_sleepDurationFragment)
        )
        binding.btnDisorder.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_sleepDisorderFragment)
        )
        binding.btnSong.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_sleepSongsFragment)
        )
        binding.btnTips.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_tipsForSleepFragment3)
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}