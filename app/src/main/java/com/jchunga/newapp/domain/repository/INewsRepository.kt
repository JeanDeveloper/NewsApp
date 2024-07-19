package com.jchunga.newapp.domain.repository

import androidx.paging.PagingData
import com.jchunga.newapp.data.dto.Article
import com.jchunga.newapp.data.dto.NewsResponse
import kotlinx.coroutines.flow.Flow

interface INewsRepository {

    fun getNews(sources: List<String>) : Flow<PagingData<Article>>

    fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>>


    suspend fun upsertArticle(article:Article)

    suspend fun deleteArticle(article: Article)

    fun selectArticles() : Flow<List<Article>>

    suspend fun selectArticle(url:String) : Article?

}