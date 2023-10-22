package com.example.umc_5th_android.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class BannerVPAdapter(fragment: Fragment):FragmentStateAdapter(fragment) {
    // 데이터의 변경을 막기 위해 private으로 선언
    private val fragmentlist : ArrayList<Fragment> = ArrayList()
    override fun getItemCount(): Int = fragmentlist.size

    // 프래그먼트들을 생성해주는 함수
    override fun createFragment(position: Int): Fragment = fragmentlist[position] //0,1,2,3

    fun addFragment(fragment: Fragment){
        fragmentlist.add(fragment)
        notifyItemInserted(fragmentlist.size-1)
    }

}