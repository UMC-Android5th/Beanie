package com.example.umc_5th_android.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.umc_5th_android.BannerVPAdapter
import com.example.umc_5th_android.Activity.MainActivity
import com.example.umc_5th_android.Album
import com.example.umc_5th_android.AlbumRVAdapter
import com.example.umc_5th_android.R
import com.example.umc_5th_android.databinding.FragmentHomeBinding
import com.google.gson.Gson

class HomeFragment : Fragment() {
    lateinit var binding : FragmentHomeBinding
    private var albumDatas = ArrayList<Album>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        // 데이터 리스트 생성 더미 데이터
        albumDatas.apply{
            add(Album("Butter", "방탄소년단 (BTS)", R.drawable.img_album_exp))
            add(Album("Lilac", "아이유 (IU)", R.drawable.img_album_exp2))
            add(Album("Next Level", "에스파 (aespa)", R.drawable.img_album_exp3))
            add(Album("Boy with LUV", "방탄소년단 (BTS)", R.drawable.img_album_exp4))
            add(Album("BBom BBom", "모모랜드 (MOMOLAND)", R.drawable.img_album_exp5))
            add(Album("Weekend", "태연 (Tae-yeon)", R.drawable.img_album_exp6))

        }

        val albumRVAdapter = AlbumRVAdapter(albumDatas)
        binding.homeTodayMusicAlbumRv.adapter = albumRVAdapter
        binding.homeTodayMusicAlbumRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        albumRVAdapter.setMyItemClickListener(object : AlbumRVAdapter.MyItemClickListener{
            override fun onItemClick(album: Album) {
                changedAlbumFragment(album)
            }

            override fun onRemoveAlbum(position: Int) {
                albumRVAdapter.removeItem(position)
            }
        })

         val bannerAdapter = BannerVPAdapter(this)
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp))
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp2))

        binding.homeBanner.adapter = bannerAdapter
        binding.homeBanner.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        return binding.root
    }

    private fun changedAlbumFragment(album: Album) {
        (context as MainActivity).supportFragmentManager.beginTransaction()
            .replace(R.id.containers, AlbumFragment().apply {
                arguments = Bundle().apply {
                    val gson = Gson()
                    val albumJson = gson.toJson(album)
                    putString("album", albumJson)
                }
            })
            .commitAllowingStateLoss()
    }

}
