package com.jchunga.newapp.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.jchunga.newapp.core.utils.Dimens.ExtraSmallPadding2
import com.jchunga.newapp.core.utils.Dimens.MediumPadding1
import com.jchunga.newapp.data.dto.Article


@Composable
fun ArticleList(
    modifier: Modifier = Modifier,
    articles: List<Article>,
    onclick: (Article) -> Unit
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(MediumPadding1),
        contentPadding = PaddingValues(all = ExtraSmallPadding2)
    ){
        items(count = articles.size){ index ->
            val article = articles[index]
                ArticleCard(
                    article = article,
                    onClick = {onclick(article)}
                )
        }
    }
}



@Composable
fun ArticleList(
    modifier: Modifier = Modifier,
    articles: LazyPagingItems<Article>,
    onclick: (Article) -> Unit
) {
    val handlePagingResult = handlePagingResult(articles = articles)
    if(handlePagingResult){
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(MediumPadding1),
            contentPadding = PaddingValues(all = ExtraSmallPadding2),

        ){
            items(count = articles.itemCount){ index ->
                articles[index]?.let{
                    ArticleCard(
                        article = it,
                        onClick = { onclick(it) }
                    )
                }
            }
        }
    }
}

@Composable
fun handlePagingResult( articles: LazyPagingItems<Article> ) :Boolean {
    val loadState = articles.loadState
    val error = when {
        loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
        loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
        loadState.append  is LoadState.Error -> loadState.append as LoadState.Error
        else -> null
    }

    return when {
        loadState.refresh is LoadState.Loading -> {
            ShimmerEffect()
            false
        }
        error != null -> {
            EmptyScreen()
            false
        }
        else -> {
            true
        }
    }
}

@Composable
fun ShimmerEffect(){
    Column(verticalArrangement = Arrangement.spacedBy(MediumPadding1)) {
        repeat(10){
            ArticleCardShimmerEffect(
                modifier = Modifier.padding(horizontal = MediumPadding1)
            )
        }
    }
}