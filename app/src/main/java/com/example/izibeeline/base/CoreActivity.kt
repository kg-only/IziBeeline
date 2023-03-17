package com.example.izibeeline.base

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.izibeeline.R

abstract class CoreActivity : AppCompatActivity() {

    private lateinit var progressDialog: AlertDialog

    open fun setIsLoading(value: Boolean) {
        if (value) showLoading() else hideLoading()
    }

    open fun showLoading() {
        progressDialog.show()
    }

    open fun hideLoading() {
        progressDialog.dismiss()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupLoader()
    }

    private fun setupLoader() {
        progressDialog = AlertDialog.Builder(this)
            .setView(LayoutInflater.from(this).inflate(R.layout.progress_dialog, null))
            .setCancelable(false)
            .create()
        progressDialog.setOnKeyListener { _, keyCode, _ ->
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                progressDialog.dismiss()
                finish()
            }
            return@setOnKeyListener true
        }
    }

    override fun onDestroy() {
        progressDialog.dismiss()
        super.onDestroy()
    }

}