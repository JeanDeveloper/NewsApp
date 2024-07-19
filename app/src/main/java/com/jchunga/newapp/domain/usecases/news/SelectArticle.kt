package com.jchunga.newapp.domain.usecases.news

import com.jchunga.newapp.data.dto.Article
import com.jchunga.newapp.domain.repository.INewsRepository

class SelectArticle(
    private val newsRepository: INewsRepository
) {
    suspend operator fun invoke(url:String): Article? = newsRepository.selectArticle(url)
}