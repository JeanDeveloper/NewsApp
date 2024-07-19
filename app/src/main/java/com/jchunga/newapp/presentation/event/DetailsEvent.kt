package com.jchunga.newapp.presentation.event

import com.jchunga.newapp.data.dto.Article

sealed class DetailsEvent {
//    object saveArticle : DetailsEvent()

    data class InserteDeleteArticle( val article: Article): DetailsEvent()

    object RemoveSideEffect: DetailsEvent()

}