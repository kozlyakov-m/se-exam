package com.kozlyakov.project.di

import com.google.gson.Gson
import com.google.inject.servlet.ServletModule
import com.kozlyakov.project.DepartmentServlet
import com.kozlyakov.project.EmployeeServlet
import com.kozlyakov.project.HelloServlet

class GuiceServletModule : ServletModule() {
    override fun configureServlets() {
        bind(Gson::class.java).toProvider(GsonProvider::class.java)
        serve("/hello").with(HelloServlet::class.java)
        serve("/departments").with(DepartmentServlet::class.java)
        serve("/employees").with(EmployeeServlet::class.java)
    }
}