package com.example.izibeeline.base

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.example.izibeeline.ext.toast

abstract class BaseActivity<ViewModel : BaseVM, B : ViewBinding> : CoreActivity() {

    abstract val vm: ViewModel
    lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView(binding.root)
        vm.event.observe(this) {
            when (it) {
                is Event.Loading -> setIsLoading(it.isLoading)
                is Event.Notification -> toast(it.message)
                is Event.NotificationRes -> toast(it.messageRes)
                is Event.NotificationError -> toast(it.throwable.getErrorMessage(this))
            }
        }
    }

    abstract fun getViewBinding(): B

}