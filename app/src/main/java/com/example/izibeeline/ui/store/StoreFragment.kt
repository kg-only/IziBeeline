package com.example.izibeeline.ui.store

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.izibeeline.R
import com.example.izibeeline.databinding.FragmentStoreBinding
import com.example.izibeeline.ui.store.adapter.TariffViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class StoreFragment : Fragment(R.layout.fragment_store) {

    private val binding by viewBinding<FragmentStoreBinding>()
    private lateinit var adapter: TariffViewPagerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewPager()
    }

    private fun initViewPager() = with(binding) {
        adapter = TariffViewPagerAdapter(requireActivity())
        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager) { tabView, pager ->
            tabView.text = when (pager) {
                0 -> "ДОСТУПНЫЕ"
                else -> "ПОДКЛЮЧЕННЫЕ"
            }
        }.attach()
    }
}