package com.example.izibeeline.ui.help

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.izibeeline.R
import com.example.izibeeline.databinding.FragmentHelpBinding
import com.example.izibeeline.databinding.FragmentHomeBinding

class HelpFragment : Fragment(R.layout.fragment_help) {

    private val binding by viewBinding<FragmentHelpBinding>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}