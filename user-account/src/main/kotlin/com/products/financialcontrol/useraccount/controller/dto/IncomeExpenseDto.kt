package com.products.financialcontrol.useraccount.controller.dto

import com.products.financialcontrol.useraccount.model.IncomeExpenseEntity



class IncomeExpenseDto(
        val id: Long,
        val name: String,
        val type: String,
        val userAccountId: Long
) {
    constructor(incomeExpense: IncomeExpenseEntity)
            : this(incomeExpense.id!!, incomeExpense.name, incomeExpense.movementType.toString(), incomeExpense.userAccount.id!!)

    companion object {
        @JvmStatic fun toDto(incomeExpenses: List<IncomeExpenseEntity>): List<IncomeExpenseDto> {
            val listDto = arrayListOf<IncomeExpenseDto>()
            incomeExpenses.forEach { e -> listDto.add(IncomeExpenseDto(e))}
            return listDto
        }
    }
}