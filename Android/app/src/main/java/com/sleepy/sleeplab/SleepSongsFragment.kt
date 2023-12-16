package com.sleepy.sleeplab

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.TextView


class SleepSongsFragment : Fragment() {

    lateinit var mp: MediaPlayer
    lateinit var play: ImageButton
    lateinit var elapsed: TextView
    lateinit var remaining: TextView
    lateinit var position: SeekBar
    lateinit var volume: SeekBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sleep_songs, container, false)
    }

}