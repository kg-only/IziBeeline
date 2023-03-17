package com.example.izibeeline.ui.sim

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.izibeeline.R
import com.example.izibeeline.databinding.ActivityMainBinding
import com.example.izibeeline.databinding.FragmentSimBinding

class SimFragment : Fragment(R.layout.fragment_sim) {

    private val binding by viewBinding<FragmentSimBinding>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}