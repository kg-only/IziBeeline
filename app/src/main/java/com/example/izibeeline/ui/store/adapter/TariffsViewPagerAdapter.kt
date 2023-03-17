package com.example.izibeeline.ui.store.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.izibeeline.ui.store.tariffs.available.AvailableTariffsFragment
import com.example.izibeeline.ui.store.tariffs.connected.ConnectedTariffsFragment

class TariffViewPagerAdapter(fm: FragmentActivity) : FragmentStateAdapter(fm) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        val fragment = when (position) {
            0 -> AvailableTariffsFragment()
            1 -> ConnectedTariffsFragment()
            else -> throw IllegalStateException()
        }
        return fragment
    }
}