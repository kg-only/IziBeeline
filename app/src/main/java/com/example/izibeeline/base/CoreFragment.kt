package com.example.izibeeline.base

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.izibeeline.R

abstract class CoreFragment : Fragment() {

    //FIXME: 12.12.22
    // duplicates dialog from CoreActivity, cause not all fragments have a CoreActivity parent
    private lateinit var progressDialog: AlertDialog

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupLoader()
    }

    private fun setupLoader() {
        progressDialog = AlertDialog.Builder(requireContext())
            .setView(LayoutInflater.from(requireContext()).inflate(R.layout.progress_dialog, null))
            .setCancelable(false)
            .create()

        progressDialog.setOnKeyListener { _, keyCode, _ ->
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                progressDialog.dismiss()
            }
            return@setOnKeyListener true
        }
    }

    open fun setIsLoading(value: Boolean) {
        if (value) showLoading() else hideLoading()
    }

    open fun showLoading() {
        when (requireActivity()) {
            is CoreActivity -> (requireActivity() as CoreActivity).showLoading()
            else -> progressDialog.show()
        }
    }

    open fun hideLoading() {
        (requireActivity() as? CoreActivity)?.hideLoading()
        progressDialog.dismiss()
    }

}