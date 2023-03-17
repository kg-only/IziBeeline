package com.example.izibeeline.ext

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.os.Parcelable
import android.view.View
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.izibeeline.R


fun runAfter(delay: Long, runnable: () -> Unit) {
    Handler(Looper.getMainLooper()).postDelayed(runnable, delay)
}

fun Activity.finishLater() {
    Handler(Looper.getMainLooper()).postDelayed({
        this.finish()
    }, 2000)
}

inline fun uiThread(delay: Long = 0, crossinline listener: (void: Boolean) -> Unit) {
    Handler(Looper.getMainLooper()).postDelayed({
        listener(true)
    }, delay)
}

inline fun uiThreadAutoUpdate(delay: Long = 0, crossinline listener: (void: Boolean) -> Unit) {
    val handler = Handler(Looper.getMainLooper())
    handler.removeCallbacksAndMessages(null)
    handler.postDelayed({
        listener(true)
    }, delay)
}

inline fun <reified T> Activity.activityStart() {
    startActivity(Intent(this, T::class.java))
}

fun Activity.hasPermission(context: Context, vararg permissions: String): Boolean {
    permissions.forEach {
        if (ActivityCompat.checkSelfPermission(context, it) != PackageManager.PERMISSION_GRANTED) {
            return false
        }
    }
    return true
}

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.toast(message: String) {
    requireContext().toast(message)
}

fun Context.toast(@StringRes messageRes: Int) {
    this.toast(getString(messageRes))
}

fun Fragment.toast(@StringRes messageRes: Int) {
    this.toast(getString(messageRes))
}

fun View.backgroundTintColor(@ColorRes color: Int) {
    this.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(context, color))
}

fun View.backgroundDrawable(@DrawableRes drawable: Int) {
    this.background = ContextCompat.getDrawable(context, drawable)
}

fun View.backgroundColor(@ColorRes color: Int) {
    this.setBackgroundColor(ContextCompat.getColor(context, color))
}

@Suppress("UNCHECKED_CAST")
fun <T : Parcelable> Activity.getIntentExtra(name: String, clazz: Class<T>): T {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
        this.intent.extras!!.getParcelable(name, clazz)!!
    else
        this.intent.extras!!.get(name) as T
}

fun <T : Parcelable> Activity.getIntentArrayExtra(name: String, clazz: Class<T>): ArrayList<T> {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
        this.intent.extras!!.getParcelableArrayList(name, clazz)!!
    else
        this.intent.extras!!.getParcelableArrayList(name)!!
}