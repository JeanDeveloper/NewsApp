package com.jchunga.newapp.presentation.nvgraph

sealed class Route(
    val route: String,
){
    object OnBoardingScreen: Route("onBoardingScreen")
    object HomeScreen: Route("homeScreen")
    object SearchScreen: Route("searchScreen")
    object BookMarkScreen: Route("bookMarkScreen")
    object DetailsScreen: Route("detailScreen")
    object AppStartNavigation: Route("appStarNavigation")
    object NewsNavigation: Route("newsNavigation")
    object NewsNavigatorScreen: Route("newsNavigatorScreen")
}
