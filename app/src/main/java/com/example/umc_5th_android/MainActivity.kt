package com.example.umc_5th_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.umc_5th_android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // 브랜치 테스트
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
}