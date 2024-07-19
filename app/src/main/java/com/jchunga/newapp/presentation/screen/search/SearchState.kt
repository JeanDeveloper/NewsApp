package com.jchunga.newapp.presentation.screen.search

import androidx.paging.PagingData
import com.jchunga.newapp.data.dto.Article
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>? = null
)