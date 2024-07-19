package com.jchunga.newapp.domain.entity

import com.jchunga.newapp.domain.usecases.news.DeleteArticle
import com.jchunga.newapp.domain.usecases.news.GetNews
import com.jchunga.newapp.domain.usecases.news.InsertArticle
import com.jchunga.newapp.domain.usecases.news.SearchNews
import com.jchunga.newapp.domain.usecases.news.SelectArticle
import com.jchunga.newapp.domain.usecases.news.SelectArticles

data class NewsUseCases(
    val getNews: GetNews,
    val searchNews: SearchNews,
    val selectArticles: SelectArticles,
    val insertArticle: InsertArticle,
    val deleteArticle: DeleteArticle,
    val selectArticle: SelectArticle
)