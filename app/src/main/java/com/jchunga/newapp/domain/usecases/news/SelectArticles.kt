package com.jchunga.newapp.domain.usecases.news

import com.jchunga.newapp.data.dto.Article
import com.jchunga.newapp.domain.repository.INewsRepository
import kotlinx.coroutines.flow.Flow

class SelectArticles(
    private val newsRepository: INewsRepository
) {
    operator fun invoke(): Flow<List<Article>> = newsRepository.selectArticles()
}