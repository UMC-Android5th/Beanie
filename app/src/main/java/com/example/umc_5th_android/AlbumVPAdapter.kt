package com.example.umc_5th_android

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.umc_5th_android.Fragment.DetailFragment
import com.example.umc_5th_android.Fragment.SongFragment
import com.example.umc_5th_android.Fragment.VideoFragment

class AlbumVPAdapter(fragment: Fragment):FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
      return when(position){
          0-> SongFragment()
          1-> DetailFragment()
          else-> VideoFragment()
      }
    }
}