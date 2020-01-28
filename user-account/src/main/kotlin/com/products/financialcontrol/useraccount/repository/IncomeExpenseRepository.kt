package com.products.financialcontrol.useraccount.repository

import com.products.financialcontrol.useraccount.model.IncomeExpenseEntity
import org.springframework.data.jpa.repository.JpaRepository

interface IncomeExpenseRepository : JpaRepository<IncomeExpenseEntity, Long> {

    fun findByUserAccount(id: Long): List<IncomeExpenseEntity>
}