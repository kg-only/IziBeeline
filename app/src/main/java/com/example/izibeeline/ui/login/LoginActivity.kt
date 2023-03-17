package com.example.izibeeline.ui.login

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.izibeeline.R
import com.example.izibeeline.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity(R.layout.activity_login) {

    private val binding by viewBinding<ActivityLoginBinding>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUI()
    }

    private fun initUI() = with(binding) {
        backBtn.setOnClickListener { finish() }
        val list = listOf("Кыргызстан", "Казахстан", "Хуистан")
        val adapter = ArrayAdapter(this@LoginActivity, R.layout.numbers_item, list)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (list[position]) {
                    "Кыргызстан" -> prefixNumber.text = "+996"
                    "Казахстан" -> prefixNumber.text = "+7"
                    "Хуистан" -> prefixNumber.text = "+123"
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        number.doAfterTextChanged {
            if (it != null) {
                clearNumberBtn.isVisible = it.isNotEmpty()
                nextBtn.isEnabled = it.isNotEmpty()
                if (it.isNotEmpty()) {
                    nextBtn.alpha = 1f
                    numberCard.strokeWidth = 1
                } else {
                    nextBtn.alpha = 0.5f
                    numberCard.strokeWidth = 0
                }
            }
        }

        clearNumberBtn.setOnClickListener { number.setText("") }
    }
}