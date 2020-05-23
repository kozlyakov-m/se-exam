package com.kozlyakov.project.di

import com.google.inject.servlet.ServletModule
import com.kozlyakov.project.HelloServlet

class GuiceServletModule : ServletModule() {
    override fun configureServlets() {
        serve("/*").with(HelloServlet::class.java)
    }
}