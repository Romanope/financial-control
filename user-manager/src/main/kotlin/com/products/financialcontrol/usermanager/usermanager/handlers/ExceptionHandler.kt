package com.products.financialcontrol.usermanager.usermanager.handlers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleBeanValidationError(ex: MethodArgumentNotValidException): ResponseEntity<ApiError> {
        val errors: MutableList<ApiValidationError> = arrayListOf()
        ex.bindingResult.fieldErrors.forEach { it ->
            errors.add(ApiValidationError(it.field, it.defaultMessage
                    ?: "undefined error message", it.rejectedValue, it.objectName))
        }

        return buildResponseEntity(ApiError(HttpStatus.BAD_REQUEST, "Request body validation error", errors))
    }

    private fun buildResponseEntity(apiError: ApiError): ResponseEntity<ApiError> {
        return ResponseEntity.status(apiError.status!!).body(apiError)
    }
}