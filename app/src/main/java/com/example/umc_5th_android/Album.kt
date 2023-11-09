package com.example.umc_5th_android

data class Album(
    var title: String? ="",
    var singer : String? = "",
    var converImg : Int? = null,
    var songs : ArrayList<Song>? = null
)