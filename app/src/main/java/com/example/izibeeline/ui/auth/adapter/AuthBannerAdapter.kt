package com.example.izibeeline.ui.auth.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.izibeeline.ui.auth.screens.AuthFirstBannerFragment
import com.example.izibeeline.ui.auth.screens.AuthSecondBannerFragment
import com.example.izibeeline.ui.auth.screens.AuthThirdBannerFragment

class AuthBannerAdapter(fm: FragmentActivity) : FragmentStateAdapter(fm) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        val fragment = when (position) {
            0 -> AuthFirstBannerFragment()
            1 -> AuthSecondBannerFragment()
            2 -> AuthThirdBannerFragment()
            else -> throw IllegalStateException()
        }
        return fragment
    }
}