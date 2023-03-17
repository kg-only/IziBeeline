package com.example.izibeeline.ui.auth.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.izibeeline.R
import com.example.izibeeline.databinding.FragmentSecondBannerBinding

class AuthSecondBannerFragment : Fragment(R.layout.fragment_second_banner) {

    private val binding by viewBinding<FragmentSecondBannerBinding>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}