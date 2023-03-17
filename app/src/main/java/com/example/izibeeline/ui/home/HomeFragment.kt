package com.example.izibeeline.ui.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.izibeeline.R
import com.example.izibeeline.databinding.FragmentHomeBinding
import com.example.izibeeline.ext.backgroundTintColor
import com.example.izibeeline.ui.auth.adapter.AuthBannerAdapter
import com.example.izibeeline.ui.home.adapter.HomeBannerAdapter
import com.example.izibeeline.ui.home.adapter.PremierAdapter
import com.example.izibeeline.ui.store.tariffs.TestModel
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding<FragmentHomeBinding>()
    private lateinit var adapter: HomeBannerAdapter
    private val adapterPremier = PremierAdapter()
    private val handler = Handler(Looper.getMainLooper())


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        initViewPager()
    }

    private fun initUI() = with(binding) {
        premierRecycle.adapter = adapterPremier
        val a = TestModel(
            1,
            R.drawable.playlist_rv,
            "Плейлисты IZI",
            "Музыкальные подборки от диджеев страны. Проигрываем 24/7, без повторов"
        )
        val b = TestModel(
            2,
            R.drawable.just_ask_rv,
            "Мне только спросить",
            "Ждать в очереди - грустно. Сыграй в первую игру от IZI, чтобы скипнуть печальку"
        )
        adapterPremier.submitList(listOf(a,b))
    }

    private fun initViewPager() = with(binding) {
        adapter = HomeBannerAdapter(requireActivity())
        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager) { _, _ -> }.attach()

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                setSelectedPosition(position)
            }
        })
    }

    override fun onPause() {
        handler.removeCallbacksAndMessages(null)
        super.onPause()
    }

    override fun onResume() {
        initViewPager()
        super.onResume()
    }

    private fun setSelectedPosition(position: Int) = with(binding) {
        handler.removeCallbacksAndMessages(null)
        handler.postDelayed({
            when (position) {
                0 -> viewPager.setCurrentItem(1, true)
                1 -> viewPager.setCurrentItem(0, true)
            }
        }, 3000)

        when (position) {
            0 -> {
                firstIndicator.backgroundTintColor(R.color.selectedViewPager)
                secondIndicator.backgroundTintColor(R.color.notSelectedViewPager)
            }
            else -> {
                firstIndicator.backgroundTintColor(R.color.notSelectedViewPager)
                secondIndicator.backgroundTintColor(R.color.selectedViewPager)
            }
        }
    }
}