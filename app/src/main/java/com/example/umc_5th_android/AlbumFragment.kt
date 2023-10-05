package com.example.umc_5th_android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.umc_5th_android.databinding.FragmentAlbumBinding

class AlbumFragment : Fragment() {

  lateinit var binding: FragmentAlbumBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlbumBinding.inflate(inflater, container, false)

        binding.albumDown.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.containers, HomeFragment()).commitAllowingStateLoss()
        }

        binding.songLILAC.setOnClickListener {
            Toast.makeText(activity, "LILAC", Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }
}