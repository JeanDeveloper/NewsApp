package com.jchunga.newapp.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jchunga.newapp.domain.entity.NewsUseCases
import com.jchunga.newapp.presentation.screen.bookmark.BookMarkState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookMarkViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
): ViewModel(){

    private val _state  = mutableStateOf(BookMarkState())
    val state: State<BookMarkState> = _state

    init {
        viewModelScope.launch {
            getArticles()
        }
    }

    private fun getArticles(){
        newsUseCases.selectArticles().onEach { art ->
            _state.value = _state.value.copy(articles = art.asReversed())
        }.launchIn(viewModelScope)
    }

}