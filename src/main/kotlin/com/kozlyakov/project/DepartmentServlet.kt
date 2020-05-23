package com.kozlyakov.project


import com.google.gson.Gson
import com.google.inject.Inject
import com.google.inject.Singleton
import com.kozlyakov.project.dao.DepartmentDao
import xyz.sashenka.webapplication.isInteger
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Singleton
class DepartmentServlet : HttpServlet() {
    @Inject
    lateinit var departmentDao: DepartmentDao

    @Inject
    lateinit var gson: Gson

    @Throws(ServletException::class, IOException::class)
    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        //response.writer.write(gson.toJson(departmentDao.getAll()))
        val query = request.queryString
        when {
            query.isNullOrEmpty() -> response.writer.write(gson.toJson(departmentDao.getAll()))
            query.contains("id") -> handleGetRequestWithIdParameter(request, response)
            else -> response.sendError(404)
        }
    }

    private fun handleGetRequestWithIdParameter(request: HttpServletRequest, response: HttpServletResponse) {
        val idParameter = request.getParameter("id")
        if (!HandleError().sendErrorForIntegerParameterIfIsNeeded(idParameter, response)) {
            response.writer.write(gson.toJson(departmentDao.findById(idParameter.toInt())))
        }
    }


    @Throws(ServletException::class, IOException::class)
    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {

    }
}