package com.example.izibeeline.ui.home.banner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.izibeeline.R
import com.example.izibeeline.databinding.FragmentHomeFirstBannerBinding

class HomeFirstBannerFragment : Fragment(R.layout.fragment_home_first_banner) {

    private val binding by viewBinding<FragmentHomeFirstBannerBinding> ()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}