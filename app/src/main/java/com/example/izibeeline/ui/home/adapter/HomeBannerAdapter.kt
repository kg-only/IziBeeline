package com.example.izibeeline.ui.home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.izibeeline.ui.auth.screens.AuthFirstBannerFragment
import com.example.izibeeline.ui.auth.screens.AuthSecondBannerFragment
import com.example.izibeeline.ui.auth.screens.AuthThirdBannerFragment
import com.example.izibeeline.ui.home.banner.HomeFirstBannerFragment
import com.example.izibeeline.ui.home.banner.HomeSecondBannerFragment

class HomeBannerAdapter(fm: FragmentActivity) : FragmentStateAdapter(fm) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        val fragment = when (position) {
            0 -> HomeFirstBannerFragment()
            1 -> HomeSecondBannerFragment()
            else -> throw IllegalStateException()
        }
        return fragment
    }
}