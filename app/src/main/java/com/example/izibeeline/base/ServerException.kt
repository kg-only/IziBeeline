package com.example.izibeeline.base

import android.content.Context
import androidx.annotation.StringRes
import com.example.izibeeline.R
import java.io.IOException

class ServerException(
    var code: Int,
    var errorBody: ServerExceptionBody
) : IOException() {

    fun getErrorMessage(context: Context): String {
        return when {
            errorBody.message != null -> errorBody.message!!
            errorBody.messageRes != null -> context.getString(errorBody.messageRes!!)
            else -> context.getString(R.string.network_error)
        }
    }
}

class ServerExceptionBody(
    val code: String? = null,
    val message: String? = null, //to provide error message from server
    val exceptionType: String? = null,
    @StringRes var messageRes: Int? = null  //to provide error message from resources
)