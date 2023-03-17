package com.example.izibeeline

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.izibeeline.databinding.ActivityMainBinding
import com.example.izibeeline.ext.backgroundColor
import com.example.izibeeline.ext.backgroundDrawable


class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding by viewBinding<ActivityMainBinding>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUI()
    }

    private fun initUI() = with(binding) {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHost) as NavHostFragment
        val navController = navHostFragment.navController
        bottomNavigation.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.homeFragment)
                bottomMiddleButtonBackground.backgroundDrawable(R.drawable.gradient_button_background)
            else
                bottomMiddleButtonBackground.backgroundColor(R.color.bottomButtonBackground)
        }
    }
}