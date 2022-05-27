package com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.config

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus


@ControllerAdvice
class ExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    fun showCustomMessage(e: Exception?): Map<String, Any> {
        val response: MutableMap<String, Any> = HashMap()
        response["status"] = HttpStatus.BAD_REQUEST.value()
        response["message"] = e?.message ?: ""
        return response
    }
}
