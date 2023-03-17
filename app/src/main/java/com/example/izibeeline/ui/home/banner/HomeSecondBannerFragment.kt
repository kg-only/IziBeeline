package com.example.izibeeline.ui.home.banner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.izibeeline.R
import com.example.izibeeline.databinding.FragmentHomeFirstBannerBinding
import com.example.izibeeline.databinding.FragmentHomeSecondBannerBinding

class HomeSecondBannerFragment : Fragment(R.layout.fragment_home_second_banner) {

    private val binding by viewBinding<FragmentHomeSecondBannerBinding>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}