package com.example.izibeeline.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.example.izibeeline.ext.toast

abstract class BaseFragment<ViewModel : BaseVM, Binding : ViewBinding> : CoreFragment() {

    abstract val vm: ViewModel
    lateinit var binding: Binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.event.observe(viewLifecycleOwner) {
            when (it) {
                is Event.Loading -> setIsLoading(it.isLoading)
                is Event.Notification -> toast(it.message)
                is Event.NotificationRes -> toast(it.messageRes)
                is Event.NotificationError -> toast(it.throwable.getErrorMessage(requireContext()))
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getViewBinding(inflater, container)
        return binding.root
    }

    abstract fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): Binding
}