package com.sleepy.sleeplab.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
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

        binding.cvDuration.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_sleepDurationActivity)
        )
        binding.cvDisorder.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_sleepDisorderActivity)
        )
//        binding.cvSong.setOnClickListener(
//            Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_sleepSongsFragment)
//        )
        binding.cvTips.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_tipsForSleepActivity)
        )
        binding.cvSongs.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_homeFragment_to_sleepSongsActivity)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}