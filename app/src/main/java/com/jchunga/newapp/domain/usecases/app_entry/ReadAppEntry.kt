package com.jchunga.newapp.domain.usecases.app_entry

import com.jchunga.newapp.domain.repository.IDataStoreRepository
import kotlinx.coroutines.flow.Flow

class ReadAppEntry (
    private val dataStoreRepository: IDataStoreRepository
){
    operator fun invoke() : Flow<Boolean> {
        return dataStoreRepository.readAppEntry()
    }
}