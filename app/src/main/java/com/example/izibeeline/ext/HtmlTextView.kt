package com.example.izibeeline.ext

import android.content.Context
import android.text.Html
import android.text.Spanned
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class HtmlTextView(context: Context, attrs: AttributeSet) :
    AppCompatTextView(context, attrs) {

    init {
        text = text.toString().useHtml()
    }
}

fun String.useHtml() : Spanned =
    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
        Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY)
    }else
        Html.fromHtml(this)