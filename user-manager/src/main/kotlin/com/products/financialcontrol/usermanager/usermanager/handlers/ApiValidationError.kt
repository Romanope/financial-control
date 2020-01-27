package com.products.financialcontrol.usermanager.usermanager.handlers

import com.fasterxml.jackson.annotation.JsonInclude

class ApiValidationError(
        val field: String,
        val message: String,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        val rejectedValue: Any? = null,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        val objectName: String? = null)