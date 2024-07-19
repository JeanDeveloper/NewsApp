package com.jchunga.newapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.jchunga.newapp.data.dto.Article
import com.jchunga.newapp.data.dto.Source
import com.jchunga.newapp.data.local.NewsDao
import com.jchunga.newapp.presentation.nvgraph.NavGraph
import com.jchunga.newapp.presentation.viewmodel.MainViewModel
import com.jchunga.newapp.ui.theme.NewAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val mainViewModel by viewModels<MainViewModel>()
//
//    @Inject
//    lateinit var dao: NewsDao

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        actionBar?.hide()
        enableEdgeToEdge()

        WindowCompat.setDecorFitsSystemWindows(window,false)

//        lifecycleScope.launch {
//            dao.insert(
//                Article(
//                    author = "Andrii Degeler",
//                    title = "TNW Podcast: Ariane 6 brings hope; how European companies use AI",
//                    description = "Welcome to the new episode of the TNW Podcast — the show where we discuss the latest developments in the European technology ecosystem and feature interviews with some of the most interesting people in the industry. In today’s episode, Linnea and Andrii tal…",
//                    content = "Welcome to the new episode of the TNW Podcast the show where we discuss the latest developments in the European technology ecosystem and feature interviews with some of the most interesting people in… [+648 chars]",
//                    publishedAt = "2024-07-17T14:32:52Z",
//                    source = Source(
//                        id = "",
//                        name =  "bbc"
//                    ),
//                    url = "https://thenextweb.com/news/ariane-6-brings-hope-how-european-companies-use-ai",
//                    urlToImage = "https://img-cdn.tnwcdn.com/image/tnw-blurple?filter_last=1&fit=1280%2C640&url=https%3A%2F%2Fcdn0.tnwcdn.com%2Fwp-content%2Fblogs.dir%2F1%2Ffiles%2F2024%2F06%2Ftnw-podcast-feat-gimp.jpg&signature=f2f8403a596c92e0062e2c007746c222"
//                )
//            )
//        }

        installSplashScreen().apply {
            setKeepOnScreenCondition {
                mainViewModel.splashCondition
            }
        }

        setContent {
            NewAppTheme {

                val isSystemInDarkTheme = isSystemInDarkTheme()
                val systemController = rememberSystemUiController()

                SideEffect{
                    systemController.setSystemBarsColor(
                        color = Color.Transparent,
                        darkIcons = !isSystemInDarkTheme
                    )
                }

                Box(
                    modifier = Modifier.background(
                        color = MaterialTheme.colorScheme.background
                    )
                ) {
                    val startDestination = mainViewModel.startDestination
                    NavGraph(startDestination = startDestination)
                }

            }
        }

    }

}
