package com.kozlyakov.project.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import javax.inject.Provider

class GsonProvider: Provider<Gson> {
    override fun get(): Gson {
        return GsonBuilder().setPrettyPrinting().create()
    }
}