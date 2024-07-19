package com.jchunga.newapp.presentation.screen.bookmark

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import com.jchunga.newapp.R
import com.jchunga.newapp.core.utils.Dimens.MediumPadding1
import com.jchunga.newapp.data.dto.Article
import com.jchunga.newapp.presentation.common.ArticleList
import com.jchunga.newapp.presentation.nvgraph.Route

@Composable
fun BookMarkScreen(
    state: BookMarkState,
    navigateToDetails:(Article) -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(top = MediumPadding1, end = MediumPadding1, start = MediumPadding1)
    ) {

        Text(
            text = "BookMark",
            style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.text_title)
        )
        Spacer(modifier = Modifier.height(MediumPadding1))
        ArticleList(
            articles = state.articles,
            onclick = {
                navigateToDetails(it)
            }
        )

    }

}