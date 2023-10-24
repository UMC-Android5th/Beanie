package com.example.umc_5th_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.umc_5th_android.data.Song
import com.example.umc_5th_android.databinding.ActivitySongBinding

class SongActivity : AppCompatActivity() {
    lateinit var binding : ActivitySongBinding
    lateinit var song : Song
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initSong()
        setPlayer(song)

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

    private fun initSong(){
        if(intent.hasExtra("title") && intent.hasExtra("singer")){
            song = Song(
                intent.getStringExtra("title")!!,
                intent.getStringExtra("singer")!!,
                intent.getIntExtra("second", 0),
                intent.getIntExtra("playTime", 0),
                intent.getBooleanExtra("isPlaying", false)
            )
        }
    }

    private fun setPlayer(song : Song){
        binding.songTitle.text = intent.getStringExtra("title")!!
        binding.songSingerName.text = intent.getStringExtra("singer")!!
        binding.songStartTime.text = String.format("%02d:%02d", song.second / 60, song.second % 60)
        binding.songEndTime.text = String.format("%02d:%02d", song.playTime / 60, song.playTime % 60)
        binding.songProgressSb.progress = (song.second * 1000 / song.playTime)

        setPlayerStatus(song.isPlaying)

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

    inner class Timer()
}