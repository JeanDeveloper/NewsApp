package com.jchunga.newapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.jchunga.newapp.data.datasource.remote.NewsApi
import com.jchunga.newapp.data.datasource.remote.NewsPagingSource
import com.jchunga.newapp.data.datasource.remote.SearchNewsPagingSource
import com.jchunga.newapp.data.dto.Article
import com.jchunga.newapp.data.local.NewsDao
import com.jchunga.newapp.domain.repository.INewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepository(
    private val newsApi: NewsApi,
    private val newsDao: NewsDao
) : INewsRepository {

    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig( pageSize = 10 ),
            pagingSourceFactory = {
                NewsPagingSource(
                    newsApi = newsApi,
                    sources = sources.joinToString(",")
                )
            }
        ).flow
    }

    override fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchNewsPagingSource(
                    searchQuery = searchQuery,
                    newsApi = newsApi,
                    sources = sources.joinToString(",")
                )
            }
        ).flow
    }

    override suspend fun upsertArticle(article: Article) = newsDao.insert(article)

    override suspend fun deleteArticle(article: Article) = newsDao.delete(article)

    override fun selectArticles(): Flow<List<Article>>  = newsDao.getArticles()

    override suspend fun selectArticle(url: String): Article?  = newsDao.getArticle(url)

}