package com.jchunga.newapp.core.utils

import androidx.annotation.DrawableRes
import com.jchunga.newapp.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int,
)

val pages = listOf(
    Page(
        "Lorem Ipsum is simply dummy",
        "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit..",
        R.drawable.onboarding1
    ),
    Page(
        "Lorem Ipsum is simply dummy",
        "Description 2",
        R.drawable.onboarding2
    ),
    Page(
        "Lorem Ipsum is simply dummy",
        "Description 3",
        R.drawable.onboarding3
    ),
)
