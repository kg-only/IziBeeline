package com.example.izibeeline.ui.auth

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.izibeeline.MainActivity
import com.example.izibeeline.R
import com.example.izibeeline.databinding.ActivityAuthBinding
import com.example.izibeeline.ext.activityStart
import com.example.izibeeline.ext.backgroundTintColor
import com.example.izibeeline.ui.auth.adapter.AuthBannerAdapter
import com.example.izibeeline.ui.login.LoginActivity
import com.google.android.material.tabs.TabLayoutMediator


class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding
    private lateinit var adapter: AuthBannerAdapter
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initViewPager()
        initUI()
    }

    private fun initUI() = with(binding) {
        registerBtn.setOnClickListener { activityStart<MainActivity>() }
        loginBtn.setOnClickListener { activityStart<LoginActivity>() }
    }

    private fun initViewPager() = with(binding) {
        adapter = AuthBannerAdapter(this@AuthActivity)
        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager) { _, _ -> }.attach()

        viewPager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                setSelectedPosition(position)
            }
        })
    }

    private fun setSelectedPosition(position: Int) = with(binding) {
        handler.removeCallbacksAndMessages(null)
        handler.postDelayed({
            when (position) {
                0 -> viewPager.setCurrentItem(1, true)
                1 -> viewPager.setCurrentItem(2, true)
                2 -> viewPager.setCurrentItem(0, true)
            }
        }, 3000)

        when (position) {
            0 -> {
                mainText.text = "IZI на связи"
                descriptionText.text = "IZI - это оператор связи без абонентской платы и обнуления трафика в конце месяца."
                firstIndicator.backgroundTintColor(R.color.selectedViewPager)
                secondIndicator.backgroundTintColor(R.color.notSelectedViewPager)
                thirdIndicator.backgroundTintColor(R.color.notSelectedViewPager)
            }
            1 -> {
                mainText.text = "Подключай на IZI"
                descriptionText.text = "Переходи на IZI со своим номером или заведи новый. Закажи SIM-карту и мы доставим её бесплатно или подключи eSIM - виртуальный аналог."
                firstIndicator.backgroundTintColor(R.color.notSelectedViewPager)
                secondIndicator.backgroundTintColor(R.color.selectedViewPager)
                thirdIndicator.backgroundTintColor(R.color.notSelectedViewPager)
            }
            2 -> {
                mainText.text = "Оператор развлечений IZI"
                descriptionText.text = "Теперь все в одном месте: подкасты, радио, игры и сотовая связь доступны в два клика."
                firstIndicator.backgroundTintColor(R.color.notSelectedViewPager)
                secondIndicator.backgroundTintColor(R.color.notSelectedViewPager)
                thirdIndicator.backgroundTintColor(R.color.selectedViewPager)
            }
        }
    }
}