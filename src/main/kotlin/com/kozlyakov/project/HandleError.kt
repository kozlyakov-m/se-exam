package com.kozlyakov.project


import xyz.sashenka.webapplication.isInteger
import javax.servlet.http.HttpServletResponse

class HandleError {

    fun sendErrorNotFound(response: HttpServletResponse) {
        response.sendError(404)
    }

    fun sendErrorForIntegerParameterIfIsNeeded(parameter: String?, response: HttpServletResponse): Boolean {
        if (parameter.isNullOrEmpty()) {
            sendErrorParameterIsEmpty(response)
            return true
        } else if (!parameter.isInteger()) {
            sendErrorParameterIsNotInteger(response)
            return true
        }
        return false
    }

    private fun sendErrorParameterIsEmpty(response: HttpServletResponse) {
        response.sendError(400, "Parameter is empty")
    }

    private fun sendErrorParameterIsNotInteger(response: HttpServletResponse) {
        response.sendError(400, "Parameter is not integer")
    }
}
