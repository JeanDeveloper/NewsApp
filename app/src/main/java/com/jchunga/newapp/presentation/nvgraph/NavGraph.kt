package com.jchunga.newapp.presentation.nvgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.jchunga.newapp.presentation.screen.bookmark.BookMarkScreen
import com.jchunga.newapp.presentation.screen.navigator.NewsNavigator
import com.jchunga.newapp.presentation.screen.onboarding.OnBoardingScreen
import com.jchunga.newapp.presentation.viewmodel.BookMarkViewModel
import com.jchunga.newapp.presentation.viewmodel.OnBoardingViewModel

@Composable
fun NavGraph(
    startDestination: String,
    onBoardingViewModel: OnBoardingViewModel = hiltViewModel()
){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination){

        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ){
            composable(
                route = Route.OnBoardingScreen.route
            ){
                OnBoardingScreen(
                    event = onBoardingViewModel::onEvent
                )
            }
        }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigatorScreen.route
        ){
            composable(
                route = Route.NewsNavigatorScreen.route
            ){
                NewsNavigator()

//                val viewModel : BookMarkViewModel = hiltViewModel()
//                BookMarkScreen(state = viewModel.state.value, navigate = {})
//                HomeScreen(articles = articles, navigate = {})
            }
        }

    }
}