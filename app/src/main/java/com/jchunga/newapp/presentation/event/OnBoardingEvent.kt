package com.jchunga.newapp.presentation.event

sealed class OnBoardingEvent {
    object SaveAppEntry: OnBoardingEvent()
}