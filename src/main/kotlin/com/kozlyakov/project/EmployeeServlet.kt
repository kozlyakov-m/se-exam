package com.kozlyakov.project



import com.google.gson.Gson
import com.google.inject.Inject
import com.google.inject.Singleton
import com.kozlyakov.project.dao.DepartmentDao
import com.kozlyakov.project.dao.EmployeeDao
import com.kozlyakov.project.domain.Department
import com.kozlyakov.project.domain.Employee
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Singleton
class EmployeeServlet: HttpServlet() {
    @Inject lateinit var employeeDao: EmployeeDao

    @Inject lateinit var gson: Gson

    @Throws(ServletException::class, IOException::class)
    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        val query = request.queryString
        when {
            query.isNullOrEmpty() -> response.writer.write(gson.toJson(employeeDao.getAll()))
            query.contains("department_id") -> handleGetRequestWithDepartmentIdParameter(request, response)
            query.contains("id") -> handleGetRequestWithIdParameter(request, response)
            else -> response.sendError(404)
        }

    }
    private fun handleGetRequestWithIdParameter(request: HttpServletRequest, response: HttpServletResponse) {
        val idParameter = request.getParameter("id")
        if (!HandleError().sendErrorForIntegerParameterIfIsNeeded(idParameter, response)) {
            response.writer.write(gson.toJson(employeeDao.findById(idParameter.toInt())))
        }
    }

    private fun handleGetRequestWithDepartmentIdParameter(request: HttpServletRequest, response: HttpServletResponse) {
        val idParameter = request.getParameter("department_id")
        if (!HandleError().sendErrorForIntegerParameterIfIsNeeded(idParameter, response)) {
            response.writer.write(gson.toJson(employeeDao.findByDepartmentId(idParameter.toInt())))
        }
    }

    @Throws(ServletException::class, IOException::class)
    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
        val requestJson = request.reader.readText()
        try{
            val department = gson.fromJson(requestJson, Employee::class.java)
            employeeDao.save(department)
            response.status = 201
        }
        catch (e: Exception) {
            response.sendError(400, e.message)
        }
    }


    @Throws(ServletException::class, IOException::class)
    override fun doDelete(request: HttpServletRequest, response: HttpServletResponse) {
        val id = request.reader.readLine()
        if (!HandleError().sendErrorForIntegerParameterIfIsNeeded(id, response)) {
            val deleted = employeeDao.delete(id.toInt())
            if(deleted) {
                response.status = 200
            }
            else {
                response.sendError(404)
            }
        }
    }
}