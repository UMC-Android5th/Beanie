package com.example.umc_5th_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.umc_5th_android.databinding.ActivitySongBinding

class SongActivity : AppCompatActivity() {
    lateinit var binding : ActivitySongBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song)
    }
}