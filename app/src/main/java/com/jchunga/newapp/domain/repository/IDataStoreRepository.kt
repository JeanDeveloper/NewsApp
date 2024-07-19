package com.jchunga.newapp.domain.repository

import kotlinx.coroutines.flow.Flow

interface IDataStoreRepository {

    suspend fun saveAppEntry()

    fun readAppEntry(): Flow<Boolean>

}