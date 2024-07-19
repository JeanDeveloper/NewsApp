package com.jchunga.newapp.presentation.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.jchunga.newapp.R
import com.jchunga.newapp.core.utils.Dimens.ArticleCardSize
import com.jchunga.newapp.core.utils.Dimens.ExtraSmallPadding
import com.jchunga.newapp.core.utils.Dimens.ExtraSmallPadding2
import com.jchunga.newapp.core.utils.Dimens.SmallIconSize
import com.jchunga.newapp.data.dto.Article
import com.jchunga.newapp.data.dto.Source
import com.jchunga.newapp.ui.theme.NewAppTheme


@Composable
fun ArticleCard(
    modifier: Modifier = Modifier,
    article: Article,
    onClick: () -> Unit
) {
    val context = LocalContext.current
    Row(
        modifier = modifier.clickable { onClick() }
    ) {

        AsyncImage(
            model = ImageRequest.Builder(context).data(article.urlToImage).crossfade(true).build(),
            contentDescription = null,
            modifier = Modifier
                .size(ArticleCardSize)
                .clip(MaterialTheme.shapes.medium),
            contentScale = ContentScale.Crop
        )

        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = ExtraSmallPadding)
                .height(ArticleCardSize)
        ){
            Text(
                text = article.title,
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(
                    id = R.color.text_title
                ),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = article.source.name,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(id = R.color.body)
                )

                Spacer(modifier = Modifier.width(ExtraSmallPadding2))

                Icon(
                    painter = painterResource(id = R.drawable.ic_time),
                    contentDescription = null,
                    modifier = Modifier.size(SmallIconSize),
                    tint = colorResource(id = R.color.body)
                )

                Spacer(modifier = Modifier.width(ExtraSmallPadding2))

                Text(
                    text = article.publishedAt,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(id = R.color.body)
                )

            }

        }

    }
}

@Preview(showBackground = true)
@Preview(showBackground = false, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ArticleCardPreview(){
    ArticleCard(
        article = Article(
            author = "",
            content = "",
            description = "",
            publishedAt = "3 hours",
            source = Source(id = "", name = ""),
            title = "aosdfosaifdjaso jsaodfjsaidofj asdofiasjdf osad",
            url = "https://readwrite.com/wp-content/uploads/2024/05/Bitcoin-price.jpg",
            urlToImage = "https://readwrite.com/wp-content/uploads/2024/05/Bitcoin-price.jpg"
        ),
        onClick = {}
    )
}