package com.products.financialcontrol.useraccount.service

import com.products.financialcontrol.useraccount.model.IncomeExpenseEntity


interface IncomeExpenseService {

    fun save(incomeExpense: IncomeExpenseEntity): IncomeExpenseEntity

    fun findByUserAccount(userAccountId: Long): List<IncomeExpenseEntity>
}