package com.example.cinemakokplace.Components

import androidx.annotation.DrawableRes
import com.example.cinemakokplace.R


sealed class MenuItems(
    val id: Int,
    val menuName: String,
    @DrawableRes val iconId: Int
) {
    object WatchNow:MenuItems(id = 1, menuName = "Watch Now", iconId = R.drawable.watchnow)
    object ComingSoon:MenuItems(id = 2, menuName = "Coming Soon", iconId = R.drawable.comingsoon)
}