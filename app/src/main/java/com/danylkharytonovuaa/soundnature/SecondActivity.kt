package com.danylkharytonovuaa.soundnature

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.danylkharytonovuaa.soundnature.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    var binding : ActivitySecondBinding? = null
    lateinit var player : MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val intent = intent
        var audio = intent.getIntExtra("audio", Data.waves_audio)
        var image = intent.getIntExtra("image", Data.waves_intent)
        binding?.imageNature?.setImageResource(image)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        player = MediaPlayer.create(this, audio)
        binding?.imageNature?.setOnClickListener {
            player.start()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
        player.stop()
    }
}