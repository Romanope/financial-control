package com.products.financialcontrol.usermanager.usermanager.handlers

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.http.HttpStatus
import java.time.LocalDateTime

class ApiError {

    var status: HttpStatus? = null

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    val timestamp: LocalDateTime = LocalDateTime.now()

    var message: String? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    var validationErros: List<ApiValidationError>? = null

    constructor(status: HttpStatus) {
        this.status = status
    }

    constructor(status: HttpStatus, message: String) {
        this.status = status
        this.message = message
    }

    constructor(status: HttpStatus, message: String, validationErros: List<ApiValidationError>) {
        this.status = status
        this.message = message
        this.validationErros = validationErros
    }
}