package com.jchunga.newapp.domain.entity

import com.jchunga.newapp.domain.usecases.app_entry.ReadAppEntry
import com.jchunga.newapp.domain.usecases.app_entry.SaveAppEntry

data class AppEntryUseCases(
    val readAppEntry: ReadAppEntry,
    val saveAppEntry: SaveAppEntry
)
