package com.kozlyakov.project



import com.google.inject.Inject
import com.google.inject.Singleton
import com.kozlyakov.project.dao.DepartmentDao
import com.kozlyakov.project.dao.EmployeeDao
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Singleton
class EmployeeServlet: HttpServlet() {
    @Inject lateinit var employeeDao: EmployeeDao

    @Throws(ServletException::class, IOException::class)
    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        response.writer.write(employeeDao.getAll().toString())

    }

    @Throws(ServletException::class, IOException::class)
    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {

    }
}