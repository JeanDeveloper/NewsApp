package com.jchunga.newapp.presentation.screen.bookmark

import com.jchunga.newapp.data.dto.Article

data class BookMarkState(
    val articles: List<Article> = emptyList()
)
