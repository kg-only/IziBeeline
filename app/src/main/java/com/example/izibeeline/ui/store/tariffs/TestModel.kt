package com.example.izibeeline.ui.store.tariffs

import androidx.annotation.DrawableRes

data class TestModel(
    var id: Int,
    @DrawableRes var img: Int?=null,
    var textTitle: String?=null,
    var textDescription: String?=null,
)
