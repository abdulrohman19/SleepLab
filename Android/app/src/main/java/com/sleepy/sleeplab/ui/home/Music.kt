package com.sleepy.sleeplab.ui.home

import android.media.MediaPlayer
import android.widget.SeekBar

object Music {
    fun setSeekBar(seekBar: SeekBar, mp: MediaPlayer, volume: Boolean? = null, seekTo: Boolean? = null){
        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser){
                    when{
                        volume == null -> mp.seekTo(progress)
                        seekTo == null -> {
                            val volumeNum = progress / 100.0f
                            mp.setVolume(volumeNum, volumeNum)
                        }
                    }
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(p0: SeekBar?) {}

        })
    }

    fun createTimeLabel(time: Int): String{
        var timelabel = ""
        val min = time / 1000 / 60
        val sec = time / 1000 % 60

        timelabel = "$min:"
        if (sec < 10) timelabel += "0"
        timelabel += sec

        return timelabel

    }
}