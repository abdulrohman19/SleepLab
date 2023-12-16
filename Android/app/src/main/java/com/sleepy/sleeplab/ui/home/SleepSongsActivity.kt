package com.sleepy.sleeplab.ui.home

import android.annotation.SuppressLint
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.TextView
import com.sleepy.sleeplab.R

class SleepSongsActivity : AppCompatActivity() {

    lateinit var mp: MediaPlayer
    lateinit var play: ImageButton
    lateinit var elapsed: TextView
    lateinit var remaining: TextView
    lateinit var position: SeekBar
    lateinit var volume: SeekBar
    private var resultTime = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sleep_songs)

        play = findViewById(R.id.ib_play)
        elapsed = findViewById(R.id.tv_elapsed)
        remaining = findViewById(R.id.tv_remaining)
        position = findViewById(R.id.sb_position)
        volume = findViewById(R.id.sb_volume)

        mp = MediaPlayer.create(this, R.raw.music)

        play.setOnClickListener {
            if (mp.isPlaying){
                mp.pause()
                play.setImageResource(R.drawable.ic_play)
            }else{
                mp.start()
                play.setImageResource(R.drawable.ic_pause)
            }
        }
        mp.isLooping = true
        mp.setVolume(0.5f, 0.5f)
        resultTime = mp.duration
        position.max = resultTime

        Music.setSeekBar(volume,mp,true)
        Music.setSeekBar(position,mp,null,true)

        val handler = @SuppressLint("HandlerLeak")
        object : Handler(){
            override fun handleMessage(msg: Message) {
                val currentPosition = msg.what
                position.progress = currentPosition
                val elapsedTime = Music.createTimeLabel(currentPosition)
                elapsed.text = elapsedTime
                val remainingTime = Music.createTimeLabel(resultTime - currentPosition)
                remaining.text = "- $remainingTime"
            }
        }

        Thread(Runnable {
            while (true){
                try {
                    val msg = Message()
                    msg.what = mp.currentPosition
                    handler.sendMessage(msg)
                    Thread.sleep(1000)
                }catch (e: InterruptedException){
                    Log.d("Thread",e.message.toString())
                }
            }
        }).start()
    }
}