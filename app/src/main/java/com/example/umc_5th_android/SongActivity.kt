package com.example.umc_5th_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.umc_5th_android.databinding.ActivitySongBinding

class SongActivity : AppCompatActivity() {
    lateinit var binding : ActivitySongBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.songDown.setOnClickListener {
            finish()
        }
        binding.songMiniplayerBtn.setOnClickListener {
            setPlayerStatus(false)
        }
        binding.songPauseBtn.setOnClickListener {
            setPlayerStatus(true)
        }
        if(intent.hasExtra("title")&&intent.hasExtra("singer")){
            binding.songTitle.text = intent.getStringExtra("title")
            binding.songSingerName.text = intent.getStringExtra("singer")
        }
    }
    fun setPlayerStatus(isPlaying: Boolean){
        if(isPlaying){
            binding.songMiniplayerBtn.visibility = View.VISIBLE
            binding.songPauseBtn.visibility = View.GONE
        }else{
            binding.songMiniplayerBtn.visibility = View.GONE
            binding.songPauseBtn.visibility = View.VISIBLE
        }
    }
}