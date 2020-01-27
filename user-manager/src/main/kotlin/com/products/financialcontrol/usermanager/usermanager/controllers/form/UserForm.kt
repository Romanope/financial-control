package com.products.financialcontrol.usermanager.usermanager.controllers.form

import com.products.financialcontrol.usermanager.usermanager.model.User
import javax.validation.constraints.NotBlank

class UserForm(
        @get: NotBlank(message = "field is not nullable")
        val email: String?,

        @get: NotBlank(message = "field is not nullable")
        val password: String?) {

        fun toEntity() = User(null, this.email!!, this.password!!, null)
}