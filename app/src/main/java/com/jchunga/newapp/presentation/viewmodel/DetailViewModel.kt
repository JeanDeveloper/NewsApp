package com.jchunga.newapp.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jchunga.newapp.data.dto.Article
import com.jchunga.newapp.domain.entity.NewsUseCases
import com.jchunga.newapp.presentation.event.DetailsEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
) : ViewModel(){

    var sideEffect by mutableStateOf<String?>(null)
        private set

    fun onEvent(event:DetailsEvent){
        when(event) {
            is DetailsEvent.InserteDeleteArticle -> {
                viewModelScope.launch {
                    val article = newsUseCases.selectArticle(event.article.url)
                    if (article == null) {
                        upsertArticle(event.article)
                    } else {
                        deleteArticle(event.article)
                    }
                }

            }
            DetailsEvent.RemoveSideEffect -> {
                sideEffect = null
            }
        }

    }

    private suspend fun upsertArticle(article: Article){
        newsUseCases.insertArticle(article)
        sideEffect = "Article Inserted"
    }

    private suspend fun deleteArticle(article:Article){
        newsUseCases.deleteArticle(article)
        sideEffect = "Article Deleted"
    }

}