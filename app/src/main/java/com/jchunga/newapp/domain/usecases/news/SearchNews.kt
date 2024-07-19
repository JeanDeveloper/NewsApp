package com.jchunga.newapp.domain.usecases.news

import androidx.paging.PagingData
import com.jchunga.newapp.data.dto.Article
import com.jchunga.newapp.domain.repository.INewsRepository
import kotlinx.coroutines.flow.Flow

class SearchNews(
    private val newsRepository: INewsRepository
){
    operator fun invoke(searchQuery: String, sources:List<String>): Flow<PagingData<Article>> {
        return newsRepository.searchNews(searchQuery, sources)
    }
}