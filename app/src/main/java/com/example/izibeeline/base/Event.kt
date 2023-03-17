package com.example.izibeeline.base

import androidx.annotation.StringRes

sealed class Event: CoreEvent {
    class Loading(val isLoading: Boolean): Event()
    class Notification(val message: String): Event()
    class NotificationError(val throwable: ServerException): Event()
    class NotificationRes(@StringRes val messageRes: Int): Event()
}

interface CoreEvent