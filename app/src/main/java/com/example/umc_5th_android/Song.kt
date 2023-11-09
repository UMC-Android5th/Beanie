package com.example.umc_5th_android
// Song의 data clas

data class Song(
    val title : String = "",
    val singer: String = "" ,
    var second : Int = 0,
    var playTime : Int = 0,
    var isPlaying : Boolean = false,
    var music : String = "music_lilac",
    var isLike: Boolean = false
)
