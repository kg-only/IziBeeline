package com.example.izibeeline

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import com.example.izibeeline.ext.finishLater
import com.example.izibeeline.ext.runAfter
import com.example.izibeeline.ui.auth.AuthActivity


@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity(R.layout.activity_splash) {

    private lateinit var logo: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logo = findViewById(R.id.logo)
    }

    override fun onStart() {
        super.onStart()
        runAfter(1000) {
            openMainScreenAndFinish()
        }
    }

    private fun openMainScreenAndFinish() {
        val intent = Intent(this, AuthActivity::class.java)
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
            this, logo, "logo"
        )
        ActivityCompat.startActivity(this, intent, options.toBundle())
        finishLater()
    }
}