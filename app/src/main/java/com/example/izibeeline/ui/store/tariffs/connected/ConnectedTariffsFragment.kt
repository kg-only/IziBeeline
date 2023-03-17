package com.example.izibeeline.ui.store.tariffs.connected

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.izibeeline.R
import com.example.izibeeline.databinding.FragmentConnectedTariffsBinding
import com.example.izibeeline.databinding.FragmentStoreBinding

class ConnectedTariffsFragment : Fragment(R.layout.fragment_connected_tariffs) {

    private val binding by viewBinding<FragmentConnectedTariffsBinding>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onResume() {
        super.onResume()
        requireView().requestLayout()
    }
}