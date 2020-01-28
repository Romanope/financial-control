package com.products.financialcontrol.useraccount.controller

import com.products.financialcontrol.useraccount.controller.dto.IncomeExpenseDto
import com.products.financialcontrol.useraccount.controller.form.IncomeExpenseForm
import com.products.financialcontrol.useraccount.service.IncomeExpenseService
import com.products.financialcontrol.useraccount.service.UserAccountService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/income-expenses")
class IncomeExpenseController(
        val incomeExpenseService: IncomeExpenseService,
        val userAccountService: UserAccountService) {

    @PostMapping
    fun create(@RequestBody @Valid incomeExpenseForm: IncomeExpenseForm,
               uriBuilder: UriComponentsBuilder): ResponseEntity<IncomeExpenseDto> {
        val incomeExpense = incomeExpenseService.save(incomeExpenseForm.toEntity(userAccountService))
        val location = uriBuilder.path("/income-expensess/{id}").buildAndExpand(incomeExpense.id).toUri()
        return ResponseEntity.created(location).body(IncomeExpenseDto(incomeExpense))
    }

}