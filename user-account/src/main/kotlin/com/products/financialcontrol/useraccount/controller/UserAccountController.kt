package com.products.financialcontrol.useraccount.controller

import com.products.financialcontrol.useraccount.controller.dto.IncomeExpenseDto
import com.products.financialcontrol.useraccount.controller.dto.UserAccountDto
import com.products.financialcontrol.useraccount.controller.form.UserAccountForm
import com.products.financialcontrol.useraccount.service.IncomeExpenseService
import com.products.financialcontrol.useraccount.service.UserAccountService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/user-accounts")
class UserAccountController(val userAccountService: UserAccountService,
                            val incomeExpenseService: IncomeExpenseService) {

    @PostMapping
    fun create(@RequestBody @Valid userAccountForm: UserAccountForm,
               uriBuilder: UriComponentsBuilder): ResponseEntity<UserAccountDto> {
        val userAccount = userAccountService.save(userAccountForm.toEntity())
        val uri = uriBuilder.path("/user-accounts/{id}").buildAndExpand(userAccount.id).toUri()
        return ResponseEntity.created(uri).body(UserAccountDto(userAccount))
    }

    @GetMapping("/{id}/income-expenses")
    fun listIncomeExpenses(@PathVariable id: Long): ResponseEntity<List<IncomeExpenseDto>> {
        val incomeExpenses = incomeExpenseService.findByUserAccount(id)
        return ResponseEntity.ok(IncomeExpenseDto.toDto(incomeExpenses))
    }
}