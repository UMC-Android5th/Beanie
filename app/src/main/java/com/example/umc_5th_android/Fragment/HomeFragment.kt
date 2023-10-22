package com.example.umc_5th_android.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.umc_5th_android.adapter.BannerVPAdapter
import com.example.umc_5th_android.MainActivity
import com.example.umc_5th_android.R
import com.example.umc_5th_android.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding : FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.homeAlbumImg1.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.containers, AlbumFragment()).commitAllowingStateLoss()
        }

         val bannerAdapter = BannerVPAdapter(this)
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp))
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp2))

        binding.homeBanner.adapter = bannerAdapter
        binding.homeBanner.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        return binding.root
    }

}
