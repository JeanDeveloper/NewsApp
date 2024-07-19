package com.jchunga.newapp.domain.usecases.app_entry

import com.jchunga.newapp.domain.repository.IDataStoreRepository

class SaveAppEntry(
    private val dataStoreRepository: IDataStoreRepository
) {
    suspend operator fun invoke() {
        dataStoreRepository.saveAppEntry()
    }
}