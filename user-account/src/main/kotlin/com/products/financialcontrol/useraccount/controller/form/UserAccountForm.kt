package com.products.financialcontrol.useraccount.controller.form

import com.products.financialcontrol.useraccount.model.UserAccountEntity
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

class UserAccountForm(
        @get: NotNull(message = "field is not be nullable")
        val userId: Long) : Form<UserAccountEntity> {
    override fun toEntity() = UserAccountEntity(null, userId)
}