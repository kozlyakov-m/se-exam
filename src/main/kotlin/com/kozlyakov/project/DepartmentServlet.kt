package com.kozlyakov.project



import com.google.gson.Gson
import com.google.inject.Inject
import com.google.inject.Singleton
import com.kozlyakov.project.dao.DepartmentDao
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Singleton
class DepartmentServlet: HttpServlet() {
    @Inject lateinit var departmentDao: DepartmentDao

    @Inject lateinit var gson: Gson

    @Throws(ServletException::class, IOException::class)
    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        response.writer.write(gson.toJson(departmentDao.getAll()))

    }

    @Throws(ServletException::class, IOException::class)
    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {

    }
}