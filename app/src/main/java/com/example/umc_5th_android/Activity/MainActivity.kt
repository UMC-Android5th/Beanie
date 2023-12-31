package com.example.umc_5th_android.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.umc_5th_android.Fragment.HomeFragment
import com.example.umc_5th_android.Fragment.LockerFragment
import com.example.umc_5th_android.Fragment.LookFragment
import com.example.umc_5th_android.Fragment.SearchFragment
import com.example.umc_5th_android.R
import com.example.umc_5th_android.Song
import com.example.umc_5th_android.databinding.ActivityMainBinding
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var song : Song = Song()
    private var gson: Gson = Gson()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_FLO)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val song = Song(binding.mainMiniplayerTitle.text.toString(), binding.mainMiniplayerSinger.text.toString(), 0, 60, false)
        Log.d("Song", song.title + song.singer)

        binding.mainPlayerCl.setOnClickListener{
            val intent = Intent(this, SongActivity::class.java)
            intent.putExtra("title", song.title)
            intent.putExtra("singer", song.singer)
            intent.putExtra("second", song.second)
            intent.putExtra("playTime", song.playTime)
            intent.putExtra("isPlaying", song.isPlaying)
            intent.putExtra("music", song.music)
            startActivity(intent)
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.containers, HomeFragment())
            .commitAllowingStateLoss()

        binding.bottomNavigationview.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.HomeFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.containers, HomeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.LookFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.containers, LookFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.SearchFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.containers, SearchFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.LockerFragment ->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.containers, LockerFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }

    }
    private fun setMiniPlayer(song: Song){
        binding.mainMiniplayerTitle.text = song.title
        binding.mainMiniplayerSinger.text = song.singer
        binding.mainMiniplayerProgressSb.progress = (song.second * 1000000) / song.playTime
    }

    override fun onStart(){
        super.onStart()
        val sharedPreferences = getSharedPreferences("song", MODE_PRIVATE)
        val songJson = sharedPreferences.getString("songData", null)

        song = if(songJson == null){
            Song("라일락", "아이유(IU)", 0, 60, false, "music_lilac")
        }else{
            gson.fromJson(songJson, Song::class.java)
        }
        setMiniPlayer(song)
    }
}