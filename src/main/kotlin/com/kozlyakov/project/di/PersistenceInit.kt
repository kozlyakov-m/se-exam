package com.kozlyakov.project.di

import com.google.inject.Inject
import com.google.inject.persist.PersistService

class PersistenceInitializer @Inject constructor(service: PersistService) {
    init {
        service.start()
    }
}
