package com.products.financialcontrol.useraccount.controller.form

import com.products.financialcontrol.useraccount.enum.MovementTypeEnum
import com.products.financialcontrol.useraccount.model.IncomeExpenseEntity
import com.products.financialcontrol.useraccount.service.UserAccountService
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

class IncomeExpenseForm(
        @get: NotNull(message = "field is not be nullable")
        val userAccountId: Long,
        @get: NotBlank(message = "field is not be nullable")
        val type: String,
        @get: NotBlank(message = "field is not be nullable")
        val name: String

) {
   fun toEntity(userAccountService: UserAccountService): IncomeExpenseEntity {
     return IncomeExpenseEntity(null, name, MovementTypeEnum.valueOf(type), userAccountService.findById(userAccountId))
   }
}