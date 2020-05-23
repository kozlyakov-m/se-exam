package com.kozlyakov.project.di

import com.google.inject.servlet.ServletModule
import com.kozlyakov.project.DepartmentServlet
import com.kozlyakov.project.EmployeeServlet
import com.kozlyakov.project.HelloServlet

class GuiceServletModule : ServletModule() {
    override fun configureServlets() {
        serve("/hello").with(HelloServlet::class.java)
        serve("/departments").with(DepartmentServlet::class.java)
        serve("/employees").with(EmployeeServlet::class.java)
    }
}