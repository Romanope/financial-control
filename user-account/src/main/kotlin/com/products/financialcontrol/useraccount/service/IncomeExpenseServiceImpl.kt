package com.products.financialcontrol.useraccount.service

import com.products.financialcontrol.useraccount.controller.dto.IncomeExpenseDto
import com.products.financialcontrol.useraccount.model.IncomeExpenseEntity
import com.products.financialcontrol.useraccount.repository.IncomeExpenseRepository
import org.springframework.stereotype.Service

@Service
class IncomeExpenseServiceImpl(val incomeExpenseRepository: IncomeExpenseRepository) : IncomeExpenseService {
    override fun save(incomeExpense: IncomeExpenseEntity): IncomeExpenseEntity {
        return incomeExpenseRepository.save(incomeExpense)
    }

    override fun findByUserAccount(userAccountId: Long): List<IncomeExpenseEntity> {
        return incomeExpenseRepository.findByUserAccount(userAccountId)
    }
}